package MemoryManagement;

class MyObject{
    String message;
    MyObject (String message){
        this.message = message;
    }
}

public class MemoryDemo {
    public static void main(String args[]){
        //this happens on stack
        greet(); //Method call pushed on to the stack.
    }

    static void greet(){
        //Object creating happens on heap
        MyObject myObject = new MyObject("Hello ! from my object\n");
        System.out.println(myObject.message);
    }
}
