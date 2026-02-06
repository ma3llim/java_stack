import java.util.Scanner;

public class Product {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double num1, num2;
        System.out.print("Enter the first number: ");
        num1 = input.nextDouble();
        
        System.out.print("Enter the second number: ");
        num2 = input.nextDouble();
        
        System.out.println("Product of both number: " + (num1 * num2));
    }
}