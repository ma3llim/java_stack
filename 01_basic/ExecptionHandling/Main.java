package ExecptionHandling;

import ExecptionHandling.File.FileProcessor;
import ExecptionHandling.Student.Student;
import ExecptionHandling.Student.StudentManager;
import ExecptionHandling.bank.BankAccount;
import ExecptionHandling.exceptions.*;

public class Main {
    public static void main(String[] args) throws InvalidAgeException, DuplicateStudentException {
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

        System.out.println();
        System.out.println("=========================================================================================");
        System.out.println();
        FileProcessor processor = new FileProcessor();
        processor.readFile();
        System.out.println();
        processor.writeFile("Hello at the end of the file");
        processor.readFile();
        System.out.println();

        System.out.println("=========================================================================================");
        System.out.println();
        Student student1 = new Student(1,"Sameer",19);
        Student student2 = new Student(1,"Sameer",19);
        StudentManager.addStudent(student1);
        StudentManager.addStudent(student2);
    }
}