package BasicOfThreads.ThreadUsageExample;

class SumTask extends Thread{
    private int[] arr;
    private int start, end;
    private long result = 0;

    public SumTask(int[]arr, int start, int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public void run(){
        for(int i = start; i < end; i++){
            result += arr[i];
        }
    }

    //getter for result 
    public long getResult(){
        return this.result;
    }
}

public class ArraySumExample {
    public static void main(String[] args) {
        //lets create and initiliaze an Array
        int[] arr = new int[100];

        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }

        SumTask sum1 = new SumTask(arr, 0, arr.length/2);
        SumTask sum2 = new SumTask(arr, arr.length / 2, arr.length);

        sum1.start();
        sum2.start();

        try{
            sum1.join();
            sum2.join();
        }catch(InterruptedException e){
            System.out.println("System Interrupted");
        }

        long totalSum = sum1.getResult() + sum2.getResult();
        System.out.println("The Total sum is:  " + totalSum);
    }
}
