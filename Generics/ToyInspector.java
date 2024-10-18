package Generics;

public class ToyInspector {
    public void inspectToy(ToyFactory<?> factory){
        System.out.println("Ispecting toy : "+ factory.getToy());
    }
}
