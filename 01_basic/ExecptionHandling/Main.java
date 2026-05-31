package ExecptionHandling;
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Sameer", 1000);

        try {
            account.displayBalance();
            account.deposit(500);
            account.withdraw(300);
            account.deposit(-100);
        }
        catch (InvalidAmountException e) {
            System.out.println("InvalidAmountException: " + e.getMessage());
        }
        catch (InsufficientBalanceException e) {
            System.out.println("InsufficientBalanceException: "+ e.getMessage());
        }
        finally {
            System.out.println("Transaction processing completed.");
        }
    }
}