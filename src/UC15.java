class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}
class GoodsBogie {
    private String shape; // e.g., "RECTANGULAR", "CYLINDRICAL"
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            // Validation logic
            if (cargoType.equalsIgnoreCase("PETROLEUM") &&
                    shape.equalsIgnoreCase("RECTANGULAR")) {

                // Throw custom runtime exception
                throw new CargoSafetyException(
                        "Unsafe assignment: Petroleum cannot be loaded in rectangular bogie."
                );
            }

            // Safe assignment
            this.cargo = cargoType;
            System.out.println("Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            // Graceful error handling
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Assignment attempt completed for bogie shape: " + shape);
        }
    }
}
public class UC15 {
    public static void main(String[] args) {
        GoodsBogie bogie1 = new GoodsBogie("RECTANGULAR");
        GoodsBogie bogie2 = new GoodsBogie("CYLINDRICAL");

        // Unsafe case (will trigger exception)
        bogie1.assignCargo("PETROLEUM");

        System.out.println("---------------------");

        // Safe case
        bogie2.assignCargo("PETROLEUM");

        System.out.println("Program continues safely...");
    }
}