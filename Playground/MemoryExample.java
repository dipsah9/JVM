package Playground;

public class MemoryExample {

    public static void main(String[] args) {
        //lets create a large object to see memory allocation

        int[] largeArray = new int[100000];
        long mb = 1024 * 1024;

        //lets print the current memory usage
        Runtime runtime = Runtime.getRuntime();
        long memoryUsed = runtime.totalMemory()-runtime.freeMemory();
        System.out.println("Memory used is: " + memoryUsed/mb);
    }
}