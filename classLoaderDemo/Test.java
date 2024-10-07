package classLoaderDemo;

public class Test {
    public static void main(String[] args) {
        System.out.println("ClassLoader for String: "+String.class.getClassLoader());  
        System.out.println("ClassLoader for Student: " + Student.class.getClassLoader());
        System.out.println("ClassLoader for Test: " + Test.class.getClassLoader());
    }
}
