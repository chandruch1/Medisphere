

class AssociationDriver {
    private String name;

    public AssociationDriver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class AssociationCar {
    private String model;

    public AssociationCar(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

public class AssociationDemo {
    public static void main(String[] args) {
        System.out.println("=== Association (Relationship between Objects) ===");

        // Two independent objects
        AssociationDriver driver = new AssociationDriver("Alex");
        AssociationCar car = new AssociationCar("Toyota Supra");

        // The association is established when we use them together
        System.out.println(driver.getName() + " is driving a " + car.getModel());
        
        // They can easily be dissociated and reassigned
        AssociationDriver driver2 = new AssociationDriver("Sarah");
        System.out.println(driver2.getName() + " has now taken over driving the " + car.getModel());
    }
}
