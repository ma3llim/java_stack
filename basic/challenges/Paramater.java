import java.util.Scanner;

public class Paramater {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the four number of rectangle: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();

        System.out.println("Result: " + (a+b+c+d));
    }
}