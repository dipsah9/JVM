package JNI;

public class NativeExample {
    
    //Declare a native method
    public native int add(int a, int b);

    //Declare the library 
    static{
        System.loadLibrary("NativLib");
        System.out.println("Library path: " + System.getProperty("java.library.path"));
    }

    public static void main(String[] args) {
        NativeExample example = new NativeExample();
        int result = example.add(5, 3);
        System.out.println("Result: " + result);
    }

}
