
class HierarchicalShape {
    protected String color;

    public HierarchicalShape(String color) {
        this.color = color;
    }

    public void displayColor() {
        System.out.println("Shape Color: " + color);
    }
}

// Child Class 1 (Extends Shape)
class HierarchicalCircle extends HierarchicalShape {
    private double radius;

    public HierarchicalCircle(String color, double radius) {
        super(color); // Set color in parent class
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void displayCircleInfo() {
        displayColor(); // Inherited method
        System.out.println("Circle radius: " + radius);
        System.out.println("Circle Area: " + String.format("%.2f", calculateArea()));
    }
}

// Child Class 2 (Extends Shape)
class HierarchicalRectangle extends HierarchicalShape {
    private double length;
    private double width;

    public HierarchicalRectangle(String color, double length, double width) {
        super(color); // Set color in parent class
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public void displayRectangleInfo() {
        displayColor(); // Inherited method
        System.out.println("Rectangle dimensions: " + length + " x " + width);
        System.out.println("Rectangle Area: " + calculateArea());
    }
}

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Hierarchical Inheritance Demonstration ===");

        System.out.println("\n--- Instantiating and using Circle (Child 1) ---");
        HierarchicalCircle redCircle = new HierarchicalCircle("Red", 5.0);
        redCircle.displayCircleInfo();

        System.out.println("\n--- Instantiating and using Rectangle (Child 2) ---");
        HierarchicalRectangle blueRectangle = new HierarchicalRectangle("Blue", 4.0, 6.0);
        blueRectangle.displayRectangleInfo();
    }
}
