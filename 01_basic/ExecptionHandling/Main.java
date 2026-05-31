package ExecptionHandling;

import ExecptionHandling.bank.BankAccount;
import ExecptionHandling.exceptions.InsufficientBalanceException;
import ExecptionHandling.exceptions.InsufficientFundsException;
import ExecptionHandling.exceptions.InvalidAmountException;

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
        } catch (InsufficientFundsException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Transaction processing completed.");
        }
    }
}