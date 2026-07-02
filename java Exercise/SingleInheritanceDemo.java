
class SingleInheritanceDevice {
    protected String brand;
    protected double price;

    // Parent Class Constructor
    public SingleInheritanceDevice(String brand, double price) {
        this.brand = brand;
        this.price = price;
        System.out.println("Device constructor called for: " + this.brand);
    }

    public void powerOn() {
        System.out.println(brand + " device is now powering ON...");
    }

    public void displayBasicDetails() {
        System.out.println("Brand: " + brand + ", Price: $" + price);
    }
}

// Child Class (Subclass) demonstrating Single Inheritance
class SingleInheritanceSmartphone extends SingleInheritanceDevice {
    private String operatingSystem;

    // Child Class Constructor
    public SingleInheritanceSmartphone(String brand, double price, String operatingSystem) {
        // Calling parent class constructor using super keyword
        super(brand, price);
        this.operatingSystem = operatingSystem;
        System.out.println("Smartphone constructor called for operating system: " + this.operatingSystem);
    }

    public void launchApp(String appName) {
        System.out.println("Launching " + appName + " on " + brand + " running " + operatingSystem);
    }

    // Overriding the displayBasicDetails method to add extra smartphone specific details
    @Override
    public void displayBasicDetails() {
        super.displayBasicDetails(); // Call parent class method
        System.out.println("Operating System: " + operatingSystem);
    }
}

public class SingleInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Single Inheritance Demonstration ===");

        // Instantiating the child class (Smartphone)
        SingleInheritanceSmartphone myPhone = new SingleInheritanceSmartphone("Samsung", 999.99, "Android");

        System.out.println("\n--- Invoking Inherited and Subclass Methods ---");
        // Inherited method from Device
        myPhone.powerOn();

        // Custom method in Smartphone
        myPhone.launchApp("WhatsApp");

        // Overridden method that calls parent version as well
        myPhone.displayBasicDetails();
    }
}
