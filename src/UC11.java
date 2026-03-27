import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UC11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Train Consist Management App ===");

        // Define regex patterns
        String trainIdPattern = "TRN-\\d{4}";      // Example: TRN-1234
        String cargoCodePattern = "PET-[A-Z]{2}";   // Example: PET-AB

        // Compile patterns
        Pattern trainPattern = Pattern.compile(trainIdPattern);
        Pattern cargoPattern = Pattern.compile(cargoCodePattern);

        // Read user input
        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        // Create matcher objects
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validate Train ID
        if (trainMatcher.matches()) {
            System.out.println("Train ID is valid.");
        } else {
            System.out.println("Invalid Train ID format. Example: TRN-1234");
        }

        // Validate Cargo Code
        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is valid.");
        } else {
            System.out.println("Invalid Cargo Code format. Example: PET-AB");
        }

        scanner.close();
    }
}