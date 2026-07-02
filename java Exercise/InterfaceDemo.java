interface DemoFlyable {
    // Implicitly public static final
    int MAX_ALTITUDE_FEET = 40000;

    // Implicitly public abstract
    void takeOff();
    void fly();
    void land();
}

// Class implementing the contract
class DemoAirplane implements DemoFlyable {
    private String model;

    public DemoAirplane(String model) {
        this.model = model;
    }

    @Override
    public void takeOff() {
        System.out.println("Airplane " + model + " is speeding down the runway and taking off.");
    }

    @Override
    public void fly() {
        System.out.println("Airplane " + model + " is cruising in the sky.");
    }

    @Override
    public void land() {
        System.out.println("Airplane " + model + " has deployed landing gear and landed safely.");
    }
}

// Another class implementing the same contract differently
class DemoHelicopter implements DemoFlyable {
    private String model;

    public DemoHelicopter(String model) {
        this.model = model;
    }

    @Override
    public void takeOff() {
        System.out.println("Helicopter " + model + " is lifting off vertically from the helipad.");
    }

    @Override
    public void fly() {
        System.out.println("Helicopter " + model + " is hovering and flying forward.");
    }

    @Override
    public void land() {
        System.out.println("Helicopter " + model + " is descending vertically to touch down.");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstraction via Interfaces ===");
        System.out.println("Max Flyable Altitude: " + DemoFlyable.MAX_ALTITUDE_FEET + " feet.\n");

        // Interface reference pointing to implementation class objects
        DemoFlyable aircraft1 = new DemoAirplane("Boeing 747");
        DemoFlyable aircraft2 = new DemoHelicopter("Bell 206");

        System.out.println("--- Flying Airplane ---");
        aircraft1.takeOff();
        aircraft1.fly();
        aircraft1.land();

        System.out.println("\n--- Flying Helicopter ---");
        aircraft2.takeOff();
        aircraft2.fly();
        aircraft2.land();
    }
}
