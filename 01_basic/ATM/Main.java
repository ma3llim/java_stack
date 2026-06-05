package ATM;

import ATM.model.Account;
import ATM.model.CurrentAccount;
import ATM.model.PrintStatement;
import ATM.model.SavingsAccount;
import ATM.services.ATMService;

public class Main {
    public static void main(String[] args){
        ATMService service = new ATMService();

        Account account1 = new SavingsAccount("1","Mohd Sameer", "9885191161", "Hyderabad",6000.0);
        Account account2 = new SavingsAccount("2","Mohd Younus", "9885191161", "Hyderabad",6000.0);
        Account account3 = new CurrentAccount("3","Mohd Fahad", "9885191161", "Hyderabad",6000.0);
        Account account4 = new CurrentAccount("4","Mohd Khaja", "9885191161", "Hyderabad",6000.0);

        // Saving accounts ATM
        service.createdAccount(account1);
        service.createdAccount(account2);
        service.createdAccount(account3);
        service.createdAccount(account4);

        account1.deposit(900);
        account1.transfer(account2, 100);

        // Closed the ATM
        service.closedAccount(account4);
    }
}
