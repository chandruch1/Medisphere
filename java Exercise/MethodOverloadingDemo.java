

class OverloadedMathOperations {
    // 1. Overloaded method: Sum of two integers
    public int add(int a, int b) {
        System.out.println("Calling add(int, int)");
        return a + b;
    }

    // 2. Overloaded method: Sum of three integers (different number of parameters)
    public int add(int a, int b, int c) {
        System.out.println("Calling add(int, int, int)");
        return a + b + c;
    }

    // 3. Overloaded method: Sum of two doubles (different data types)
    public double add(double a, double b) {
        System.out.println("Calling add(double, double)");
        return a + b;
    }

    // 4. Overloaded method: Different order/sequence of parameters
    public void printDetails(String name, int id) {
        System.out.println("Student Name: " + name + ", ID: " + id);
    }

    public void printDetails(int id, String name) {
        System.out.println("Student ID: " + id + ", Name: " + name + " (Reversed parameters overload)");
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        System.out.println("=== Method Overloading Demonstration ===");

        OverloadedMathOperations math = new OverloadedMathOperations();

        // Calling overloaded add methods
        int sumInt = math.add(10, 20);
        System.out.println("Result (2 ints): " + sumInt + "\n");

        int sumThreeInts = math.add(10, 20, 30);
        System.out.println("Result (3 ints): " + sumThreeInts + "\n");

        double sumDouble = math.add(10.5, 20.7);
        System.out.println("Result (2 doubles): " + sumDouble + "\n");

        // Calling overloaded printDetails methods
        math.printDetails("Alice", 101);
        math.printDetails(102, "Bob");
    }
}
