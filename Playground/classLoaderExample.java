package Playground;

public class classLoaderExample {
    public static void main(String[] args) {
        ClassLoader classLoader = classLoaderExample.class.getClassLoader();
        System.out.println("Application ClassLoader: " + classLoader);
        System.out.println("Parent ClassLoader (Extension): " + classLoader.getParent());
        System.out.println("Grandparent ClassLoader (Bootstrap): " + classLoader.getParent().getParent()); 
    }
}
