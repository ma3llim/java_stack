
package ControlSatements;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        int userInput = 1;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        userInput = input.nextInt();
        long result = recursionFactorial(userInput);
        System.out.println("Factorial of your number is: " + result);
    }

    public static long recursionFactorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number * recursionFactorial(number - 1);
    }
}
