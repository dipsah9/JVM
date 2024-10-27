package Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String []args){
        List<String> name = Arrays.asList("Deep","Ajith", "Jibson");
        Stream<String> stream = name.stream(); //Convert arrays of name in Stream
       // stream.forEach(System.out::println);

        //lets do filter operation on the stream we created. 
        name.stream()
        //the names we used here..need to go through this
        .filter(names -> names.startsWith("A"))
        .forEach(System.out::println);

        name.stream()
        .map(String::toUpperCase) // Convert to uppercase
        .forEach(System.out::println); // This will print "ALICE", "BOB", "CHARLIE"

         name.stream()
        .sorted()
        .forEach(System.out::println); // This will print names in alphabetical order

    }
}
