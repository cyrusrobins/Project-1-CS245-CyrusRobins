import java.util.ArrayList;
import java.util.Random;

public class HybridSort {

    public static void sort(double[] arr, int run_size)
    {
        int currRunNumIndex = 0; //keeps track of the most recent index of the run
        int currRunLength = 1; //keeps track of the length of the current run
        ArrayList<Run> Runs = new ArrayList<Run>(); //keeps track of which indecies are in a run
        for(int i=1;i<arr.length;i++){
            if(arr[i]<=arr[currRunNumIndex]){ //if the order stops descending, reset the run length and add all of the
                if(currRunLength>=run_size){  //indecies of the run to the array list
                    Runs.add(new Run(currRunLength,currRunNumIndex-currRunLength+1));
                }
                if(arr.length-currRunNumIndex>=run_size) { //if there are enough terms left for another run
                    // start a new run beginning with the term in the array you are currently on
                    currRunLength = 1;
                }
                else { //if there aren't enough terms left, exit the loop, as you have all of the runs in the array
                    break;
                }
            }
            else{ //otherwise increment the length of the run
                currRunLength++;
                //System.out.println("The current run length at index " + i + " is: " + currRunLength);
            }
            currRunNumIndex++; //increment the most recent index checked
        }
        BubbleSort.sort(arr,0,Runs.get(0).getStartingIndex()-1); //sort everything before the first run
        for(int i=0;i<Runs.size()-1;i++){
            if(Runs.get(i).getEndingIndex()+1!=Runs.get(i+1).getStartingIndex()-1) {//if the next two runs don't start and end in the same place, then sort what's inbetween
                BubbleSort.sort(arr, Runs.get(i).getEndingIndex()+1, Runs.get(i+1).getStartingIndex()-1);
            }
        }
        BubbleSort.sort(arr,Runs.get(Runs.size()-1).getEndingIndex()+1,arr.length-1); //sort everything after the last run in the array

        boolean isNotSorted = true; //boolean expression to determine whether the array has fully been sorted
        int run1EndIndex = -1, run2EndIndex = -1; //initialize the values to keep track of the relevant indecies of the two most recent runs
        while(isNotSorted){
            int newRunCounter = 0; //increments each time a new run is encountered
            int run1StartIndex = 0; //the first run starts at index 0
            isNotSorted = false; //change this by default so if there are no changes made in the array then the while loop ends
            for(int j=0;j<arr.length-1;j++){ //loop through the array
                if(arr[j]>arr[j+1]){ //if the array is out of order
                    if(newRunCounter%2==0) { //if this is an even numbered run
                        run1EndIndex = j; //rewrite the ending of the end index for the first run
                        newRunCounter++; //increment the number of runs
                        isNotSorted = true; //tell the while loop it must continue
                    }
                    else if(newRunCounter%2==1){ //if this is an odd numbered run
                        run2EndIndex = j; //rewrite the ending index for the second run
                        newRunCounter++; //increment the number of runs
                        isNotSorted = true;
                        if(newRunCounter%2==0) //if we have a pair of runs next to each other, then merge them
                            MergeSort.merge(arr,run1StartIndex,run2EndIndex,run1EndIndex); //merge the adjacent runs
                        run1StartIndex = j + 1; //set the start index of the next run to be the next slot in the array
                    }
                }
                if(j==arr.length-2&&newRunCounter%2==1){ //if the end of the array is reached and there are an odd number of runs
                    run2EndIndex = arr.length-1; //set the last run in the array to be from the end of the previous run to the end of the array
                    MergeSort.merge(arr,run1StartIndex,run2EndIndex,run1EndIndex); //merge the last two runs
                }
            }
        }
    }
}
