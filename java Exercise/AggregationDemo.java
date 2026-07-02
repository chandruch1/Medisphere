import java.util.ArrayList;
import java.util.List;

// Child Class
class AggregationProfessor {
    private String name;
    private String specialization;

    public AggregationProfessor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Professor: " + name + " | Specialization: " + specialization);
    }
}

// Parent Class containing references to Child objects (Aggregation)
class AggregationDepartment {
    private String deptName;
    private List<AggregationProfessor> professors; // Aggregation: Department has a list of professors

    public AggregationDepartment(String deptName) {
        this.deptName = deptName;
        this.professors = new ArrayList<>();
    }

    public void addProfessor(AggregationProfessor prof) {
        professors.add(prof);
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        System.out.println("Professors in " + deptName + ":");
        for (AggregationProfessor prof : professors) {
            System.out.print(" - ");
            prof.displayDetails();
        }
    }
}

public class AggregationDemo {
    public static void main(String[] args) {
        System.out.println("=== Aggregation Demonstration ===");

        // 1. Create independent child objects
        AggregationProfessor prof1 = new AggregationProfessor("Dr. Alan Turing", "Computer Science");
        AggregationProfessor prof2 = new AggregationProfessor("Dr. Grace Hopper", "Compiler Design");

        // 2. Create parent object
        AggregationDepartment csDept = new AggregationDepartment("Computer Science & Engineering");

        // 3. Associate child objects with parent (Aggregate them)
        csDept.addProfessor(prof1);
        csDept.addProfessor(prof2);

        // 4. Display parent info
        csDept.displayDepartment();

        // 5. Demonstrate loose association:
        // Even if we set the department object to null (representing department deletion), 
        // the Professor objects (prof1, prof2) continue to exist.
        System.out.println("\n--- Shutting down Computer Science Department ---");
        csDept = null; 

        // Let's verify professors still exist
        System.out.println("Verifying if professors still exist independently:");
        prof1.displayDetails();
        prof2.displayDetails();
    }
}
