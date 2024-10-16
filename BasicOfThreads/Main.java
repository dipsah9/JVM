package BasicOfThreads;

 class MyThreads extends Thread{

    @Override
    public  void run(){
        for(int i = 0; i <= 5; i++){
            System.out.println(i + "from Thread " + this.getName());
        }     
    }

}

public class Main{
    public static void main(String[] args) {
        // MyThreads thread1 = new MyThreads();
        // thread1.start();

        // MyThreads threads2 = new MyThreads();
        // threads2.start();

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
      
    }
}
   

