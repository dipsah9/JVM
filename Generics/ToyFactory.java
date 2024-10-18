package Generics;

public class ToyFactory <T>{
    private T toy;

    public ToyFactory(T toy){
        this.toy = toy;
    }

    public void produceToy(){
        System.out.println("producing " + this.toy);
    }

    public T getToy(){
        return this.toy;
    }
}