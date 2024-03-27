// Callum Reid
// https://github.com/yathm/CS112T1GP

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {

    private CurrentAccount account;

    @BeforeEach
    public void setUp() {
        account = new CurrentAccount("John Doe", "123456789", 200);
        account.setBalance(500); // Setting an initial balance for testing
    }

    @Test
    public void testSetOverdrawAmount() {
        account.setOverdrawAmount(100);
        assertEquals(100, account.getOverdrawAmount());

        account.setOverdrawAmount(-50);
        assertEquals(0, account.getOverdrawAmount());

        account.setOverdrawAmount(350);
        assertEquals(300, account.getOverdrawAmount());
    }

    @Test
    public void testWithdrawBalance() {
        assertTrue(account.withdrawBalance(100));
        assertEquals(400, account.getBalance(), 0.001);

        // Test withdrawing amount that would lead to an overdraft within the limit
        assertTrue(account.withdrawBalance(600));
        assertEquals(-200, account.getBalance(), 0.001);

        // Test withdrawing amount that exceeds the overdraft limit
        assertFalse(account.withdrawBalance(101)); // This should fail as it exceeds the overdraw limit
        assertEquals(-200, account.getBalance(), 0.001); // Balance should remain unchanged

        // Deposit some amount to cover the overdraft
        account.setBalance(500); // Reset balance to 500

        // Test withdrawing amount greater than the balance but less than or equal to balance + overdrawAmount
        assertTrue(account.withdrawBalance(700)); // Overdrawn by 200, which is within the limit
        assertEquals(-200, account.getBalance(), 0.001);
    }
}
