package GarbageCollector;

public class GarbageCollectorExample {
    public static void main(String[] args) {
        // Create some objects with automatic cleanup using Cleaner
        Balloon redBalloon = new Balloon("Red");
        Balloon blueBalloon = new Balloon("Blue");

        // Nullifying reference to redBalloon, making it eligible for GC
        redBalloon = null;

        // Suggesting garbage collection
        System.gc();

        // Creating more objects
        blueBalloon = new Balloon("Green");

        System.out.println("Garbage Collection Example Complete");
    }
}
