import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("Sai");

        System.out.println("=== Personal Finance Tracker ===");

        while (true) {
            System.out.println("\n1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Summary");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1 || choice == 2) {
                String type = (choice == 1) ? "income" : "expense";
                System.out.print("Category: ");
                String category = scanner.nextLine();
                System.out.print("Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Description: ");
                String description = scanner.nextLine();
                account.addTransaction(new Transaction(type, category, amount, description));
                System.out.println("Added!");
            } else if (choice == 3) {
                account.printTransactions();
            } else if (choice == 4) {
                account.printSummary();
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
        scanner.close();
    }
}