import java.util.*;

class Transaction {
    String type;
    double amount;
    Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date(); // current time
    }

    @Override
    public String toString() {
        return type + " of $" + amount + " on " + date.toString();
    }
}

class BankAccount {
    private static int idCounter = 1000;
    private String accountHolderName;
    private int accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String name) {
        this.accountHolderName = name;
        this.accountNumber = ++idCounter;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal successful.");
        }
    }

    public void viewTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

public class BankApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static BankAccount account = null;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== ATM Banking System =====");
            System.out.println("1. Create New Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    if (checkAccountExists()) account.checkBalance();
                    break;
                case 3:
                    if (checkAccountExists()) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }
                    break;
                case 4:
                    if (checkAccountExists()) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    break;
                case 5:
                    if (checkAccountExists()) account.viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);
    }

    private static void createAccount() {
        System.out.print("Enter your name: ");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();
        account = new BankAccount(name);
        System.out.println("Account created successfully.");
        System.out.println("Account Number: " + account.getAccountNumber());
    }

    private static boolean checkAccountExists() {
        if (account == null) {
            System.out.println("Please create an account first.");
            return false;
        }
        return true;
    }
}
