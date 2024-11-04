package Serialization;
import java.io.*;

class Creature implements Serializable{
    String name; 
    int level;
    transient int hiddenMove;

    Creature(String name, int level, int hiddenMove){
        this.name = name; 
        this.level = level; 
        this.hiddenMove = hiddenMove;
    }

    @Override 
    public String toString(){
        return name + "( Level " + level + "  hiddenMove Power "+ hiddenMove+ ")";
    }
}

public class Serializationfun {

    public static void main(String args[]){
        Creature pikachu = new Creature("Pikachu", 10, 100);

        //Capture pikachu 
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("creature.ser"))){
            oos.writeObject(pikachu);
        }catch(IOException e){
            e.printStackTrace();
        }
    
        // Revive (deserialize) Pikachu
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("creature.ser"))) {
            Creature revivedPikachu = (Creature) ois.readObject();
            System.out.println("Revived " + revivedPikachu + "!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
