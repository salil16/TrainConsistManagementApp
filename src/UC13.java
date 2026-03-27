import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogiie {
    String name;
    int capacity;

    Bogiie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class UC13 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Prepare a large list of bogies for testing
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 78));
            bogies.add(new Bogie("First Class", 24));
        }

        // --- Loop-based filtering ---
        long startLoop = System.nanoTime();
        List<Bogie> filteredLoop = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                filteredLoop.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long durationLoop = endLoop - startLoop;

        System.out.println("Loop-based filtering time (ns): " + durationLoop);

        // --- Stream-based filtering ---
        long startStream = System.nanoTime();
        List<Bogie> filteredStream = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long durationStream = endStream - startStream;

        System.out.println("Stream-based filtering time (ns): " + durationStream);

        // Verify results
        System.out.println("Filtered list size (loop): " + filteredLoop.size());
        System.out.println("Filtered list size (stream): " + filteredStream.size());
    }
}