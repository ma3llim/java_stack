import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius");
        double userInput = input.nextDouble();
        double area = Math.PI * userInput * userInput;
        System.out.println("Area Of Circle: " + area);
        input.close();
    }
}
