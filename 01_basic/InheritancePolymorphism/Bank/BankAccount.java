package InheritancePolymorphism.Bank;

public class BankAccount {
    private int balance;

    public void setBalance(int balance) {

        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative");
        }
    }

    public int getBalance() {
        return balance;
    }


    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.setBalance(1000);
        System.out.println(account.getBalance());

        account.setBalance(-500);
        System.out.println(account.getBalance());
    }
}
