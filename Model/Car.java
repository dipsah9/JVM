package Model;
public class Car{
    private int year;
    private String model;

    //Constructor
    public Car(String name, int year){
        this.model = name;
        this.year = year;
    }

    //getter and setter 
    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public void setModel(String  model){
        this.model = model;
    }

    public String getModel(){
        return this.model;
    }
}