public abstract class BankAccount {
    private static float lowRate;
    private static float highRate;
    private float balance;
    private String accountName;
    private String accountNumber;

    //Constructor
    public BankAccount(String accountName, String accountNumber){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }
    //Constructor


    //lowRate Getters/Setters
    public static float getLowRate() {
        return lowRate;
    }
    public void setLowRate(float lRate) {
        if (lRate < 0){
            lowRate = 0;
        } else if (lRate > highRate){
            lowRate = highRate;
        } else {
            lowRate = lRate;
        }
    }
    //lowRate Getters/Setters

    //highRate Getters/Setters
    public static float getHighRate() {
        return highRate;
    }
    public void setHighRate(float hRate) {
        if (hRate > 10){
            highRate = 10;
        } else if (lowRate > highRate){
            highRate = lowRate;
        } else {
            highRate = hRate;
        }
    }
    //highRate Getters/Setters

    //balance Getters/Setters
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    //balance Getters/Setters

    //accountName Getters/Setters
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    //accountName Getters/Setters

    //accountNumber Getters/Setters
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    //accountNumber Getters/Setters


    //Print Details Abstract Method
    public abstract void printDetails();
    //Print Details Abstract Method

    //Deduct Balance Method
    public void deductBalance(float deduction){
        this.balance -= deduction;
    }
    //Deduct Balance Method

    //Withdraw Balance Method
    public boolean withdrawBalance(float withdrawal){
        if (this.balance >= withdrawal){
            this.deductBalance(withdrawal);
            return true;
        } else {
            return false;
        }
    }
    //Withdraw Balance Method

}
