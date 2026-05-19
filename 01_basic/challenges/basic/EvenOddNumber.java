import java.util.Scanner;

public class EvenOddNumber {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter the Number: ");
        int userInput = inputScanner.nextInt();
        if (userInput%2 == 0){
            System.out.println("Your Enter Number is Even");
        }else {
            System.out.println("Your Enter Number is Odd");
        }
    }
}
