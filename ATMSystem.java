import java.util.Scanner;

public class ATMSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static double balance = 1000.0; // Initial balance (you can set your own initial balance)

public static void main(String[] args) {
        System.out.println("Welcome to the ATM System!");

        // Simulate user login (user id and pin)
        int userId = promptForUserId();
        int userPin = promptForUserPin();

        if (isValidUser(userId, userPin)) {
            System.out.println("Login successful!");
            displayMenu();
        } else {
            System.out.println("Invalid user id or pin. Exiting...");
        }
    }

    private static int promptForUserId() {
        System.out.print("Enter your user ID: ");
        return scanner.nextInt();
    }

    private static int promptForUserPin() {
        System.out.print("Enter your PIN: ");
        return scanner.nextInt();
    }

    private static boolean isValidUser(int userId, int userPin) {
        // Replace with your user validation logic (e.g., check against a database)
        return true;
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewBalance() {
        System.out.println("Your balance: $" + balance);
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            viewBalance();
        }
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            viewBalance();
        }
    }

    private static void transfer() {
        System.out.print("Enter the amount to transfer: $");
        double amount = scanner.nextDouble();

        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid amount. Please try again.");
        } else {
            System.out.print("Enter the recipient's account number: ");
            int recipientAccountNumber = scanner.nextInt();

            // Implement transfer logic here

            System.out.println("Transferred: $" + amount + " to account " + recipientAccountNumber);
            viewBalance();
        }
    }

    private static void quit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
        System.exit(0);
    }
}
