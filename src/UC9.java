import java.util.*;
import java.util.stream.Collectors;

// Reusing Bogie class
class Boggie {
    String name;
    int capacity;

    Boggie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class UC9 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 78));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70)); // another sleeper variant

        // Group bogies by name (category)
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped result
        System.out.println("Grouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Program continues...
    }
}