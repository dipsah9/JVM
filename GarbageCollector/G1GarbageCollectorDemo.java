package GarbageCollector;
public class G1GarbageCollectorDemo {
    public static void main(String[] args) {
        // Set the JVM options to use G1 GC
        // -Xms512m -Xmx512m -XX:+UseG1GC -XX:MaxGCPauseMillis=50
        // This should be set in the command line when running the program

        // Creating a large array of objects
        for (int i = 0; i < 100000; i++) {
            Object obj = new Object(); // Creating objects
            // Simulating some processing
            if (i % 10000 == 0) {
                System.out.println("Created " + i + " objects.");
            }
        }

        // Request garbage collection
        System.gc(); // Suggests to the JVM to run the GC
        System.out.println("Garbage Collection triggered.");
    }
}
