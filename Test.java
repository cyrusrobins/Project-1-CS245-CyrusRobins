import java.util.Random;

public class Test {
    public static boolean isSorted(double[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1])
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        final int run_size = 2;
        double[] hybridArr = new double[200000];
        double[] mergeArr = new double[200000];
        Random rand = new Random();
        for(int i=0;i<hybridArr.length;i++){
            hybridArr[i] = rand.nextDouble();
        }
        System.arraycopy(hybridArr,0,mergeArr,0,hybridArr.length);
        long start = System.currentTimeMillis();
        HybridSort.sort(hybridArr,run_size);
        long total_time = System.currentTimeMillis() - start;
        if(isSorted(hybridArr))
            System.out.println("Hybrid Sort Took: " + total_time + "ms");
        else
            System.out.println("Hybrid Sort didn't sort correctly");

        start = System.currentTimeMillis();
        RealMergeSort.sort(mergeArr);
        total_time = System.currentTimeMillis() - start;
        if(isSorted(mergeArr))
            System.out.println("Merge Sort Took: " + total_time + "ms");
        else
            System.out.println("Merge Sort didn't sort correctly");
    }
}
