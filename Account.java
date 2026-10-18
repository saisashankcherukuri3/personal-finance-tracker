import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Account {
    private String ownerName;
    private ArrayList<Transaction> transactions;

    public Account(String ownerName) {
        this.ownerName = ownerName;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public void printTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("\n--- All Transactions ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void printSummary() {
        double totalIncome = 0;
        double totalExpenses = 0;
        HashMap<String, Double> categoryTotals = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getType().equals("income")) {
                totalIncome += t.getAmount();
            } else {
                totalExpenses += t.getAmount();
            }
            categoryTotals.put(t.getCategory(),
                categoryTotals.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
        }

        System.out.println("\n--- Summary for " + ownerName + " ---");
        System.out.println("Total Income:   $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Net Balance:    $" + (totalIncome - totalExpenses));
        System.out.println("\nBy Category:");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void sortByAmount() {
    transactions.sort((a, b) -> Double.compare(b.getAmount(), a.getAmount()));
    System.out.println("Transactions sorted by amount (highest first).");
}

public void searchByCategory(String keyword) {
    System.out.println("\n--- Results for \"" + keyword + "\" ---");
    boolean found = false;
    for (Transaction t : transactions) {
        if (t.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
            System.out.println(t);
            found = true;
        }
    }
    if (!found) System.out.println("No transactions found.");
}
}
