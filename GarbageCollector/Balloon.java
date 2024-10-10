package GarbageCollector;
import java.lang.ref.Cleaner;

public class Balloon implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();
    private final Cleaner.Cleanable cleanable;
    private String color;

    public Balloon(String color) {
        this.color = color;
        System.out.println(color + " balloon created.");

        // Registering the cleaner to run when the Balloon is no longer reachable
        this.cleanable = cleaner.register(this, new BalloonCleanup(color));
    }

    // Cleanup logic that will be executed when the object becomes unreachable
    private static class BalloonCleanup implements Runnable {
        private String color;

        public BalloonCleanup(String color) {
            this.color = color;
        }

        @Override
        public void run() {
            System.out.println(color + " balloon is being cleaned up.");
        }
    }

    @Override
    public void close() {
        // Explicit cleanup if called
        cleanable.clean();
        System.out.println(color + " balloon manually cleaned.");
    }
}