/**
 * OOP Concept: Encapsulation
 * 
 * Encapsulation is the mechanism of wrapping data (variables) and code acting on the data 
 * (methods) together as a single unit. In encapsulation, the variables of a class will 
 * be hidden from other classes, and can be accessed only through the methods of their 
 * current class (Data Hiding).
 * 
 * Key Features shown:
 * 1. Private fields to prevent direct access.
 * 2. Public getters and setters to allow controlled read/write access.
 * 3. Validation logic inside setters to enforce business rules/constraints.
 */

class Student {
    // 1. Private variables - hidden from outside access
    private String name;
    private int age;
    private String rollNumber;

    // Constructor to initialize Student objects
    public Student(String name, int age, String rollNumber) {
        setName(name); // using setters to benefit from validation logic
        setAge(age);
        this.rollNumber = rollNumber;
    }

    // 2. Getter for Name
    public String getName() {
        return name;
    }

    // 2. Setter for Name
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Invalid name provided. Setting to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    // 2. Getter for Age
    public int getAge() {
        return age;
    }

    // 3. Setter for Age with validation
    public void setAge(int age) {
        if (age >= 5 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Warning: Invalid age (" + age + ") for a student. Setting age to default value of 18.");
            this.age = 18;
        }
    }

    // Getter for RollNumber
    public String getRollNumber() {
        return rollNumber;
    }

    // Setter for RollNumber (No setter for roll number to make it read-only after creation if needed, 
    // but we can provide one for demonstration)
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    // Helper method to display Student info
    public void displayInfo() {
        System.out.println("Student Details: [Name: " + name + ", Age: " + age + ", Roll Number: " + rollNumber + "]");
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        System.out.println("=== Encapsulation Demonstration ===");

        // Creating a student with valid details
        Student s1 = new Student("Alice Smith", 20, "S101");
        s1.displayInfo();

        // Trying to access private field directly will cause a compilation error
        // s1.name = "Bob"; // Uncommenting this line will break compilation

        // Modifying fields using setters (controlled access)
        s1.setAge(22);
        s1.setName("Alice M. Smith");
        System.out.println("\nAfter updating values via setters:");
        s1.displayInfo();

        // Testing data validation constraints in encapsulation
        System.out.println("\nTesting validation with invalid age (-5) and empty name:");
        s1.setAge(-5);
        s1.setName("");
        s1.displayInfo();
    }
}
