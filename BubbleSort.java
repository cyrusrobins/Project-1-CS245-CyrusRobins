public class BubbleSort{ //slightly modified bubble sort method

    public static void swap(int a, int b, double[] arr){
        double temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void sort(double[] arr, int startIndex, int endIndex){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i=startIndex;i<endIndex;i++){
                for(int j=startIndex; j<endIndex;j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(j, j + 1, arr);
                        swapped = true;
                    }
                }
            }
        }
    }
}