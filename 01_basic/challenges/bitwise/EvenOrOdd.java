import java.util.Scanner;

public class EvenOrOdd{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num;
        System.out.print("Enter the number: ");
        num = input.nextInt();

        if((num & 1) ==1){
            System.out.print("Your Number is Odd");
        }else {
            System.out.print("Your Number is Even");
        }
    }
}