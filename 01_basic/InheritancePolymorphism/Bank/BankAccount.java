package InheritancePolymorphism.Bank;

public class BankAccount {
    private String owner;
    private int balance;

    BankAccount(String owner, int balance){
        this.owner = owner;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Invalid balance. Set to 0");
        }
    }

    public String getOwner(){
        return owner;
    }

    public void SetOwner(String owner){
        if(!owner.isEmpty()){
            this.owner = owner;
        } else {
            System.out.println("Owner name cannot be empty");
        }
    }

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

        BankAccount account = new BankAccount("Sameer", 1000);

        account.setBalance(1000);
        System.out.println(account.getBalance());

        account.setBalance(-500);
        System.out.println(account.getBalance());
    }
}
