
interface DefaultStaticVehicleController {
    // Abstrac method (must be implemented)
    void accelerate();

    // Default method (already implemented, optional to override)
    default void blowHorn() {
        System.out.println("Vehicle Controller: Beep! Beep!");
    }

    // Static method (helper method, bound to the interface)
    static boolean checkBatteryLevel(double percentage) {
        System.out.println("Vehicle Controller Diagnostic: Checking battery level...");
        return percentage > 15.0;
    }
}

class DefaultStaticElectricScooter implements DefaultStaticVehicleController {
    private String modelName;

    public DefaultStaticElectricScooter(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void accelerate() {
        System.out.println(modelName + " scooter is accelerating silently.");
    }

    // Optionally overriding default method to customize behavior
    @Override
    public void blowHorn() {
        System.out.println(modelName + " scooter: *High-pitched beep!*");
    }
}

class DefaultStaticDeliveryTruck implements DefaultStaticVehicleController {
    private String modelName;

    public DefaultStaticDeliveryTruck(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void accelerate() {
        System.out.println(modelName + " truck diesel engine rumbles and accelerates.");
    }

    // Uses the default blowHorn() method without overriding it
}

public class InterfaceDefaultStaticDemo {
    public static void main(String[] args) {
        System.out.println("=== Interface Default and Static Methods ===");

        // 1. Testing Static Method directly from the Interface
        boolean isBatteryOk = DefaultStaticVehicleController.checkBatteryLevel(45.5);
        System.out.println("Battery Status: " + (isBatteryOk ? "OK" : "LOW") + "\n");

        // 2. Testing implementing classes
        DefaultStaticVehicleController scooter = new DefaultStaticElectricScooter("E-Rider X");
        DefaultStaticVehicleController truck = new DefaultStaticDeliveryTruck("Volvo FH16");

        System.out.println("--- Electric Scooter Actions ---");
        scooter.accelerate();
        scooter.blowHorn(); // Uses overridden default method

        System.out.println("\n--- Delivery Truck Actions ---");
        truck.accelerate();
        truck.blowHorn(); // Uses default method directly from interface
    }
}
