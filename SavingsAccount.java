// Alisha Attigan
// https://github.com/yathm/CS112T1GP

public class SavingsAccount extends BankAccount {
    //initialise variables
    private float rate;

    //constructor to extend to super class and inherit fields
    public SavingsAccount(String accountName, String accountID, float rate) {
        super(accountName, accountID);
        setRate(rate);
    }

    //getter to get rate
    public float getRate() {
        return rate;
    }
    //setter to set rates
public void setRate(float rate) {
        this.rate = rate;
    }

    // method to add interest to current balance
    public void addInterest() {
        float interest = getBalance() * (rate / 100);
        float newBalance = getBalance() + interest;
        setBalance(newBalance);
    }

    //method to print account details
    public void printDetails() {
        System.out.println("Account Name: " + getAccountName());
        System.out.println("Account id: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("Account type: Savings");
        System.out.println("Rate: " + rate + "%");
    }
}
