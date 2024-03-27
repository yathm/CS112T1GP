// Callum Reid
// https://github.com/yathm/CS112T1GP

public class CurrentAccount extends BankAccount {
    private int overdrawAmount;

    public CurrentAccount(String accountName, String accountId, int overdrawAmount) {
        super(accountName, accountId);
        setOverdrawAmount(overdrawAmount);
    }

    public int getOverdrawAmount() {
        return overdrawAmount;
    }

    public void setOverdrawAmount(int overdrawAmount) {
        // Constrain overdrawAmount between 0 and 300.
        this.overdrawAmount = Math.max(0, Math.min(overdrawAmount, 300));
    }

    @Override
    public boolean withdrawBalance(float withdrawal) {
        // Check if withdrawal is within the overdraw limit.
        if (withdrawal <= 0 || getBalance() - withdrawal < -overdrawAmount) {
            return false;
        }
        deductBalance(withdrawal);
        return true;
    }

    @Override
    public void printDetails() {
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Account id: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("Account type: Current");
        System.out.println("Overdraw: " + getOverdrawAmount());
    }
}
