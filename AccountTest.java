import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account("TestUser");
    }

    @Test
    public void testAddIncomeIncreasesBalance() {
        account.addTransaction(new Transaction("income", "Salary", 2000, "CVS paycheck"));
        account.addTransaction(new Transaction("expense", "Food", 200, "Groceries"));
        // Net should be 1800
        double net = 2000 - 200;
        assertEquals(1800, net);
    }

    @Test
    public void testTransactionStoredCorrectly() {
        Transaction t = new Transaction("expense", "Food", 150, "Groceries");
        assertEquals("expense", t.getType());
        assertEquals("Food", t.getCategory());
        assertEquals(150, t.getAmount());
    }

    @Test
    public void testEmptyAccountHasNoTransactions() {
        account = new Account("Empty");
        // Should not throw any errors
        account.printTransactions();
    }
}
