import java.util.*;

class Transaction {
    private String type;
    private double amount;
    private Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return type + " of $" + amount + " on " + date;
    }
}

class BankAccount {
    private String name;
    private int accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String name) {
        this.name = name;
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    private int generateAccountNumber() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000); // 6-digit random number
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrew: $" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}

public class ATMApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1 & 2: Start and Ask for name
        System.out.println("Welcome to the ATM Simulator!");
        System.out.print("Enter your name to create an account: ");
        String userName = scanner.nextLine();

        // Step 3: Create account
        BankAccount account = new BankAccount(userName);
        System.out.println("Account created successfully.");
        System.out.println("Account Holder: " + userName);
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: $0.0");

        // Step 4 to 8: Menu and operations loop
        while (true) {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmt = scanner.nextDouble();
                    account.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmt = scanner.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.viewTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}