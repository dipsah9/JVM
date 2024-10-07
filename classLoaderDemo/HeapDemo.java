package classLoaderDemo;

public class HeapDemo {
    public static void main(String[] args){
        long mb = 1024 * 1024;
        Runtime r  = Runtime.getRuntime();
        System.out.println("Max Memory:"+ r.maxMemory()/mb);
        System.out.println("Total memory: "+ r.totalMemory()/mb);
        System.out.println("Free Memory: "+ r.freeMemory()/mb);
        System.out.println("Consumed Memory: " + (r.totalMemory() - r.freeMemory())/mb);
        
    }
}
