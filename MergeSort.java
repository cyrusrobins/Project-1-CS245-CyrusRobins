public class MergeSort{ //for merging in hybrid sort

    public static void merge(double[] arr, int left, int right, int mid){
        double[] leftArray = new double[mid-left+1];
        double[] rightArray = new double[right-mid];
        for(int i=0;i<mid-left+1;++i){
            leftArray[i] = arr[left+i];
        }
        for(int j=0;j<right-mid;++j){
            rightArray[j] = arr[j+mid+1];
        }
        int lIndex = 0;
        int rIndex = 0;
        int arrIndex = left;
        while(lIndex<mid-left+1 && rIndex<right-mid){
            if(leftArray[lIndex]<=rightArray[rIndex]){
                arr[arrIndex] = leftArray[lIndex];
                lIndex++;
            }
            else if(leftArray[lIndex]>rightArray[rIndex]){
                arr[arrIndex] = rightArray[rIndex];
                rIndex++;
            }
            arrIndex++;
        }
        while(lIndex<mid-left+1){
            arr[arrIndex] = leftArray[lIndex];
            lIndex++;
            arrIndex++;
        }
        while(rIndex<right-mid){
            arr[arrIndex] = rightArray[rIndex];
            rIndex++;
            arrIndex++;
        }
    }
}
