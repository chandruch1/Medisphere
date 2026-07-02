
// Superclass
class OverridingEmployee {
    protected String name;
    protected double baseSalary;

    public OverridingEmployee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void work() {
        System.out.println(name + " is doing general employee work.");
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

// Subclass 1
class OverridingManager extends OverridingEmployee {
    private double bonus;

    public OverridingManager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    // Overriding work() method
    @Override
    public void work() {
        System.out.println("Manager " + name + " is managing team projects and meetings.");
    }

    // Overriding calculateSalary() method
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

// Subclass 2
class OverridingDeveloper extends OverridingEmployee {
    private String programmingLanguage;

    public OverridingDeveloper(String name, double baseSalary, String programmingLanguage) {
        super(name, baseSalary);
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding work() method
    @Override
    public void work() {
        System.out.println("Developer " + name + " is writing and debugging code in " + programmingLanguage + ".");
    }

    // Inherits base calculateSalary() without overriding it
}

public class MethodOverridingDemo {
    public static void main(String[] args) {
        System.out.println("=== Method Overriding & Runtime Polymorphism ===");

        // 1. Creating objects normally
        OverridingEmployee genEmp = new OverridingEmployee("John", 50000);
        OverridingManager mgr = new OverridingManager("Sarah", 80000, 15000);
        OverridingDeveloper dev = new OverridingDeveloper("Alex", 60000, "Java");

        System.out.println("--- Standard Method Calls ---");
        genEmp.work();
        mgr.work();
        dev.work();

        System.out.println("\n--- Dynamic Method Dispatch (Runtime Polymorphism) ---");
        // Superclass reference pointing to subclass objects
        OverridingEmployee ref1 = mgr; // Employee reference holding Manager object
        OverridingEmployee ref2 = dev; // Employee reference holding Developer object

        // JVM decides which method to call at runtime based on the actual object type, not the reference type
        ref1.work(); // Calls Manager's work()
        ref2.work(); // Calls Developer's work()

        System.out.println("\nSalary Calculations:");
        System.out.println(ref1.name + "'s Total Salary: $" + ref1.calculateSalary()); // Calls Manager's calculateSalary()
        System.out.println(ref2.name + "'s Total Salary: $" + ref2.calculateSalary()); // Calls Employee's calculateSalary() (inherited)
    }
}
