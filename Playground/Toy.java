package Playground;

public class Toy {

    public void build(){
        System.out.println("Building a Toy inside the JVM");
    }
    public static void main(String[] args){
        System.out.println("Welcome to Java factory! Let's build a toy.");

        Toy toy = new Toy();
        toy.build();

        

    }
}
