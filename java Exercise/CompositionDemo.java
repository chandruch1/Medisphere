// Child Class (Part of the whole)
class CompositionProcessor {
    private String model;
    private int cores;

    public CompositionProcessor(String model, int cores) {
        this.model = model;
        this.cores = cores;
    }

    public void runDiagnostics() {
        System.out.println("Processor " + model + " (" + cores + " cores) is processing instructions.");
    }
}

// Parent Class (The whole)
class CompositionComputer {
    private String brand;
    private CompositionProcessor cpu; // Composition: Computer owns the Processor object

    public CompositionComputer(String brand, String cpuModel, int cpuCores) {
        this.brand = brand;
        // The child object is created inside the parent. 
        // It has no independent existence outside this Computer.
        this.cpu = new CompositionProcessor(cpuModel, cpuCores);
    }

    public void startComputer() {
        System.out.println("Starting up " + brand + " computer...");
        cpu.runDiagnostics();
        System.out.println("System loaded successfully.");
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        System.out.println("=== Composition Demonstration ===");

        // Instantiating Computer automatically instantiates its Processor
        CompositionComputer myPC = new CompositionComputer("Custom Gaming Rig", "Intel i9-14900K", 24);

        System.out.println("\n--- Starting Computer ---");
        myPC.startComputer();

        // Under Composition:
        // We cannot access or use the Processor object without the Computer object.
        // If 'myPC' is set to null, the nested Processor instance is marked for garbage collection too.
        System.out.println("\n--- Decommissioning Computer ---");
        myPC = null;
        System.out.println("Computer decommissioned. Its Processor is no longer accessible and is destroyed.");
    }
}
