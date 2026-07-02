
// Abstract Class
abstract class AbstractBankAccount {
    protected String accountNumber;
    protected double balance;

    // Constructor in abstract class (can be called by child classes via super)
    public AbstractBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Concrete method - inherited by all subclasses
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + " | New Balance: $" + balance);
        }
    }

    // Concrete method
    public void displayBalance() {
        System.out.println("Account: " + accountNumber + " | Balance: $" + balance);
    }

    // Abstract method - MUST be implemented by subclasses
    public abstract void calculateAndApplyInterest();
}

// Concrete Subclass 1
class AbstractSavingsAccount extends AbstractBankAccount {
    private double interestRate; // e.g. 0.05 for 5%

    public AbstractSavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Implementing the abstract method
    @Override
    public void calculateAndApplyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Savings Interest of $" + interest + " applied. New Balance: $" + balance);
    }
}

// Concrete Subclass 2
class AbstractCheckingAccount extends AbstractBankAccount {
    private static final double MAINTENANCE_FEE = 15.00;

    public AbstractCheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // Implementing the abstract method
    @Override
    public void calculateAndApplyInterest() {
        // Checking accounts don't earn interest, instead they might deduct monthly fee
        balance -= MAINTENANCE_FEE;
        System.out.println("Checking Account fee of $" + MAINTENANCE_FEE + " deducted. New Balance: $" + balance);
    }
}

public class AbstractClassDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstraction via Abstract Classes ===");

        // Cannot instantiate abstract class directly:
        // BankAccount acc = new BankAccount("123", 1000); // Compilation Error

        // Instantiate concrete child classes using abstract reference type
        AbstractBankAccount savings = new AbstractSavingsAccount("SAV-9001", 5000.0, 0.04);
        AbstractBankAccount checking = new AbstractCheckingAccount("CHK-1002", 2000.0);

        System.out.println("\n--- Savings Account Activity ---");
        savings.displayBalance();
        savings.deposit(500);
        savings.calculateAndApplyInterest();

        System.out.println("\n--- Checking Account Activity ---");
        checking.displayBalance();
        checking.calculateAndApplyInterest();
    }
}
