package Generics;

public class Main {
    public static void main(String[] args) {
        //Car as a toy
        ToyFactory <String> toy = new ToyFactory<String>("Car");
        toy.produceToy();

        //Doll as a toy
        ToyFactory <String> toy2 = new ToyFactory<String>("Doll");
        toy2.produceToy();

        //lets instantiate the car class and doll class 
        ToyFactory <Car> car = new ToyFactory<Car>(new Car());
        car.produceToy();

        ToyFactory <Doll> doll = new ToyFactory<Doll>(new Doll());
        doll.produceToy();

        ToyInspector inspector = new ToyInspector();
        inspector.inspectToy(car);

    }
}
