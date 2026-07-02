class MultilevelVehicle {
    protected String propulsionType;

    public MultilevelVehicle(String propulsionType) {
        this.propulsionType = propulsionType;
        System.out.println("1. Vehicle (Grandparent) constructor called. Type: " + propulsionType);
    }

    public void startEngine() {
        System.out.println("Vehicle: Engine/Propulsion system is starting up.");
    }
}

// Parent Class (Extends Grandparent)
class MultilevelCar extends MultilevelVehicle {
    protected int numberOfDoors;

    public MultilevelCar(String propulsionType, int numberOfDoors) {
        super(propulsionType); // Calls Vehicle constructor
        this.numberOfDoors = numberOfDoors;
        System.out.println("2. Car (Parent) constructor called. Doors: " + numberOfDoors);
    }

    public void drive() {
        System.out.println("Car: Vehicle is rolling on four wheels.");
    }
}

// Child Class (Extends Parent)
class MultilevelElectricCar extends MultilevelCar {
    private int batteryCapacitykWh;

    public MultilevelElectricCar(String brand, int numberOfDoors, int batteryCapacitykWh) {
        super("Electric (" + brand + ")", numberOfDoors); // Calls Car constructor
        this.batteryCapacitykWh = batteryCapacitykWh;
        System.out.println("3. ElectricCar (Child) constructor called. Battery: " + batteryCapacitykWh + " kWh");
    }

    public void chargeBattery() {
        System.out.println("ElectricCar: Plugged in and charging the " + batteryCapacitykWh + " kWh battery.");
    }

    @Override
    public void drive() {
        System.out.println("ElectricCar: Driving silently with electric motors.");
    }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Multilevel Inheritance Demonstration ===");
        
        System.out.println("--- Instantiating ElectricCar (Constructor Chaining) ---");
        // Creating an ElectricCar object will trigger Vehicle -> Car -> ElectricCar constructor chain
        MultilevelElectricCar tesla = new MultilevelElectricCar("Tesla Model 3", 4, 75);

        System.out.println("\n--- Invoking methods from all levels of the hierarchy ---");
        tesla.startEngine();    // Method from Vehicle (Grandparent)
        tesla.chargeBattery();  // Method from ElectricCar (Child)
        tesla.drive();          // Overridden method in ElectricCar (Child)
    }
}
