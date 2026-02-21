package challenges;

class BankAccount {
    private String accountNumber, accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;

        if (balance >=0){
            this.balance = balance;
        }else {
            this.balance = 0;
        }
    }

    public void depositeAmount(double amount){
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public void withdrawAmount(double amount){
        if(amount <=0){
            System.out.println("Error: Withdrawal amount must be positive.");
        }else if (amount > balance){
            System.out.println("Error: Insufficient funds. Your current balance is: " + getBalance());
        }else{
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        }
    }

    public double getBalance() {
        return (long)(this.balance * 100) / 100.0;
    }

    // Optional: Method to display account details
    public void displayAccountInfo() {
        System.out.println("---------------------------");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + getBalance());
        System.out.println("---------------------------");
    }
}

public class Bank {
    public static void main(String[] args){
        BankAccount myAccount = new BankAccount("123456", "John Doe", 500.00);

        myAccount.displayAccountInfo();

        // Testing valid deposit
        myAccount.depositeAmount(150.75);

        // Testing invalid withdrawal (more than balance)
        myAccount.withdrawAmount(1000.00);

        // Testing valid withdrawal
        myAccount.withdrawAmount(200.50);

        // Final check
        myAccount.displayAccountInfo();
    }
}
