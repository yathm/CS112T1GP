// Alisha Attigan
// https://github.com/yathm/CS112T1GP

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SavingsAccountTest {
    //test to make sure set rate method works
        @Test
        public void testSetRate() {
            SavingsAccount savingsAccount = new SavingsAccount("Test Account", "123456", 3.5F);
            savingsAccount.setHighRate(5);
            savingsAccount.setRate(3.5F);
            assertEquals(3.5, savingsAccount.getRate());
            savingsAccount.setLowRate(2);
            assertEquals(2, savingsAccount.getLowRate());
            savingsAccount.setHighRate(10);
            assertEquals(10, savingsAccount.getHighRate());
        }
        //test to make sure interest is added to balance
        @Test
        public void testAddInterest() {
            SavingsAccount savingsAccount = new SavingsAccount("Test Account", "123456", 5.0F);
            savingsAccount.setBalance(100.0F);
            savingsAccount.addInterest();
            assertEquals(105.0, savingsAccount.getBalance());
        }
    }
