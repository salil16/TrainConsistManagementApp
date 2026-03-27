import java.util.ArrayList;
import java.util.List;

// Reusing Bogie class
class Boogie {
    String name;
    int capacity;

    Boogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class UC10 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));

        // Stream pipeline: map + reduce
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)          // Extract capacity
                .reduce(0, Integer::sum);     // Aggregate (sum)

        // Display result
        System.out.println("Total Seating Capacity: " + totalCapacity);

        // Program continues...
    }
}