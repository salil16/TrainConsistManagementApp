import java.util.HashSet;
import java.util.Set;

public class UC3 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create a HashSet for bogie IDs (ensures uniqueness)
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (duplicates will be ignored automatically)
        bogieIds.add("B101");
        bogieIds.add("B102");
        bogieIds.add("B103");
        bogieIds.add("B101"); // Duplicate
        bogieIds.add("B102"); // Duplicate

        // Display unique bogie IDs
        System.out.println("Unique Bogie IDs: " + bogieIds);

        // Program continues...
    }
}