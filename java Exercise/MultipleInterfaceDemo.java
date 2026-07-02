
interface MultiCamera {
    void takePhoto();
    void recordVideo();
}

interface MultiPhone {
    void makeCall(String number);
    void receiveCall();
}

// Smartphone implements both interfaces, inheriting abstract behaviors of both
class MultiSmartPhone implements MultiCamera, MultiPhone {
    private String modelName;

    public MultiSmartPhone(String modelName) {
        this.modelName = modelName;
    }

    // Implementing Camera interface methods
    @Override
    public void takePhoto() {
        System.out.println(modelName + " is snapping a high-resolution photo.");
    }

    @Override
    public void recordVideo() {
        System.out.println(modelName + " is recording a 4K video.");
    }

    // Implementing Phone interface methods
    @Override
    public void makeCall(String number) {
        System.out.println(modelName + " is dialing " + number + "...");
    }

    @Override
    public void receiveCall() {
        System.out.println(modelName + " is ringing. Swiping up to answer.");
    }

    // Smartphone's own specific method
    public void browseWeb() {
        System.out.println(modelName + " is browsing the web on 5G.");
    }
}

public class MultipleInterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Multiple Interface Implementation ===");
        
        MultiSmartPhone myDevice = new MultiSmartPhone("iPhone 15");

        System.out.println("\n--- Using Camera Capabilities ---");
        myDevice.takePhoto();
        myDevice.recordVideo();

        System.out.println("\n--- Using Phone Capabilities ---");
        myDevice.makeCall("+1-555-0199");
        myDevice.receiveCall();

        System.out.println("\n--- Using Local Subclass Capabilities ---");
        myDevice.browseWeb();
    }
}
