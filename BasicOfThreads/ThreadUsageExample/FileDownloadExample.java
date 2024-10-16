package BasicOfThreads.ThreadUsageExample;

class DownloadTask extends Thread{
    private String fileName;

    public DownloadTask(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run(){
        System.out.println("Downloading " + fileName + "...." );
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            System.out.println(fileName + " Download interuppted.");
        }
        System.out.println(fileName+ " Download completed.");
    }
}

public class FileDownloadExample {
    public static void main(String[] args) {
        Thread download1 = new DownloadTask("file1");
        Thread download2 = new DownloadTask("file2");
        Thread download3 = new DownloadTask("file3");

        download1.start();
        download2.start();
        download3.start();
        System.out.println("All downloads started!!");
    }
}
