import java.util.Scanner;

public class Arithmetic {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int num1, num2;
        System.out.println("Enter the number 1: ");
        num1 = input.nextInt();
        System.out.println("Enter the number 2: ");
        num2 = input.nextInt();

        System.out.println("Add: " + (num1 + num2));
        System.out.println("Subtract: " + (num1 - num2));
        System.out.println("Multiple: " + (num1 * num2));
        System.out.println("Divide: " + (num1 / num2));
        System.out.println("Module Divide: " + (num1 % num2));
    }
}