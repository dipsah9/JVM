package MemoryManagement;

public class GarbageCollections {
    public static void main(String args[]){
            MyObject obj1 = new MyObject("Hello World");
            MyObject obj2 = new MyObject("Hii");
            obj1 = null;
            System.gc();
    }
}

class MyObject{
    String message;

    MyObject(String message){
        this.message = message;
    }
    
    protected void cleanup(){
        System.out.println(message + "is being collected\n");
    }
}
