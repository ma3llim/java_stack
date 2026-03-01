import java.util.Scanner;

public class SumOfDigits {
    public static void main() {
        Scanner input = new Scanner(System.in);
        int userInput;
        System.out.print("Enter the Digits: ");
        userInput = input.nextInt();

        int result = sumDigits(userInput);
        System.out.println("The Sum of Digits Are: " + result);
    }

    public static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
