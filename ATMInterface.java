import java.util.Scanner;

public class ATMInterface {
    private BankAccount bankAccount;

    public ATMInterface(double initialBalance) {
        this.bankAccount = new BankAccount(initialBalance);
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + bankAccount.getBalance());
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        double currentBalance = bankAccount.getBalance();
        bankAccount.withdraw(amount);

        //  if (amount > 0 && amount <= balance) {
        //     balance -= amount;
        //     System.out.println("Withdrawal successful. " + amount + " withdrawn.");
        // } else if (amount <= 0) {
        //     System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        // } else {
        //     System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        // }
    }

    public static void main(String[] args) {
        ATMInterface atmMachine = new ATMInterface(1000.0); // Initial balance is 1000
    
        // Creating a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
    
        int choice;
        do {
            // Displaying the menu
            System.out.println("ATM Menu:");
            System.out.println("1. Display Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
    
            // Reading user choice
            choice = sc.nextInt();
    
            // Performing action based on user choice
            switch (choice) {
                case 1:
                    atmMachine.displayBalance();
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    atmMachine.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    atmMachine.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
    
            // Adding a line break for better readability
            System.out.println();
        } while (choice != 4);
    
        // Closing the sc
        sc.close();
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. " + amount + " deposited.");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. " + amount + " withdrawn.");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
        } else {
            System.out.println("Insufficient funds. Withdrawal unsuccessful.");
        }
    }
}