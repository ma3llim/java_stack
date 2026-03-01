import java.util.Scanner;

public class BitwiseOr {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num1, num2;
        System.out.print("Enter the number 1: ");
        num1 = input.nextInt();
        System.out.print("Enter the number 2: ");
        num2 = input.nextInt();

        System.out.print("Result is: " + (num1 | num2));
    }
}