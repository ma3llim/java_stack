package challenges.basic;

// BankAccount — balance, owner, deposit(), withdraw()
public class BankAccount {
    private int balance;
    private String owner;

    BankAccount(int balance, String owner){
        this.balance = balance;
        this.owner = owner;
    }

    void desposit(int amount, String owner){
        if (this.owner.equals(owner)) {
            this.balance += amount;
            System.out.println("Amount Deposite Successfully and your total is: " + balance);
        }else {
            System.out.println("Onwer not found");
        }
    }

    void withdraw(int amount, String owner){
        if (this.owner.equals(owner)) {
            if(this.balance < amount){
                System.out.println("Insufficient Balance: " + balance);
            }else {
                this.balance -= amount;
                System.out.println("Amount Deposite Successfully and your total is: " + this.balance);
            }
        }else {
            System.out.println("Onwer not found");
        }
    }

    public static void main(String[] args){
        BankAccount userBankAccount = new BankAccount(1000,"sameer");
        userBankAccount.desposit(3000, "sameer");
    }
}
