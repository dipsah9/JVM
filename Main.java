import Model.*;
import java.lang.reflect.*;

public class Main{
    public static void main(String[] args){

        int count = 0; //to count number of methods in the class formed after compiling 
        Car car = new Car("Range Rover", 1997);
        Class c = car.getClass();
        Method[] m = c.getDeclaredMethods();

        for(Method m1: m){
            count++;
            System.out.println(m1.getName());
        }

        System.out.println("Total number of method in Class "+ c.getName() + " is: " + count);

        //lets check if the class formed at jvm is formed only once or 
        //more than one for the same object 

        Car car2 = new Car("Maruti Suzuki", 1997);
        Class c2 = car2.getClass();

        int hash1 = c.hashCode();
        int hash2 = c2.hashCode();

        if(hash1 == hash2){
            System.out.println("Yes, it's same");
        }

    }
}