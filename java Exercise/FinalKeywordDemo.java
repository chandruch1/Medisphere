/**
 * OOP Concept: Restricting OOP features using the 'final' keyword
 * 
 * The 'final' keyword in Java is used to restrict the user in three ways:
 * 
 * 1. Final Variable:
 *    - Once initialized, its value cannot be changed (constant).
 *    - If it's a reference variable, it cannot point to another object, 
 *      but the internal properties of the object it references can be changed.
 * 
 * 2. Final Method:
 *    - A final method cannot be overridden by subclasses.
 *    - Used to prevent subclasses from altering critical implementation details.
 * 
 * 3. Final Class:
 *    - A final class cannot be inherited (cannot be extended).
 *    - Used to prevent inheritance and secure class implementations (e.g., String class is final).
 */

// 3. Final Class - cannot be inherited
final class FinalSecurityGateway {
    // 1. Final Variable - cannot be reassigned
    public final String ENCRYPTION_ALGORITHM = "AES/GCM/NoPadding";

    public void processSecurity() {
        System.out.println("Processing security clearance using: " + ENCRYPTION_ALGORITHM);
    }
}

// Trying to extend a final class will fail compilation
// class HackGateway extends FinalSecurityGateway {} // Compilation Error

class FinalBasicReport {
    // 1. Blank final variable (must be initialized in constructor)
    private final String reportId;

    public FinalBasicReport(String reportId) {
        this.reportId = reportId; // Initializing blank final variable
    }

    // 2. Final Method - cannot be overridden
    public final void printHeader() {
        System.out.println("=====================================");
        System.out.println("REPORT ID: " + reportId);
        System.out.println("=====================================");
    }

    public void printBody() {
        System.out.println("Generic report body content.");
    }
}

class FinalDetailedReport extends FinalBasicReport {
    public FinalDetailedReport(String reportId) {
        super(reportId);
    }

    // Trying to override printHeader will fail compilation
    /*
    @Override
    public void printHeader() {
        System.out.println("Modified Header");
    }
    */

    @Override
    public void printBody() {
        System.out.println("Detailed report body content with charts and summaries.");
    }
}

public class FinalKeywordDemo {
    public static void main(String[] args) {
        System.out.println("=== Final Keyword Demonstration ===");

        // 1. Using final variables
        final double PI = 3.14159;
        // PI = 3.14; // Compilation Error: cannot assign a value to final variable PI
        System.out.println("Constant PI value: " + PI);

        // 2. Using final classes
        FinalSecurityGateway gateway = new FinalSecurityGateway();
        gateway.processSecurity();
        // gateway.ENCRYPTION_ALGORITHM = "DES"; // Compilation Error: cannot assign value to final variable

        System.out.println("\n--- Testing Final Methods and Subclasses ---");
        // 3. Using final methods and inheritance restrictions
        FinalDetailedReport myReport = new FinalDetailedReport("RPT-2026-X");
        myReport.printHeader(); // Calls final method inherited from BasicReport
        myReport.printBody();   // Calls overridden method
    }
}
