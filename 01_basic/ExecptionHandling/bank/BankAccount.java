package ExecptionHandling.bank;

import ExecptionHandling.exceptions.InsufficientBalanceException;
import ExecptionHandling.exceptions.InsufficientFundsException;
import ExecptionHandling.exceptions.InvalidAmountException;

public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if(amount < 0){
            throw new InvalidAmountException("Deposit amount must be greater than 0");
        }
        balance += amount;
        System.out.println("Deposit Successful, Current Balance: "  + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException, InsufficientFundsException {

        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Available: " + balance);
        }

        balance -= amount;

        System.out.println("Withdrawal successful. Current balance: " + balance);
    }

    public void displayBalance() {
        System.out.println("""
                Account Details
                    Owner   : %s
                    Balance : %.2f
                """.formatted(owner, balance));
    }
}
