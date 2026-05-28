package practice;

public class operators {
    public static void main(String[] args) {
        int a = 10, b = 5;
        // Arithmetic operators
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println((double) a / b);
        System.out.println(a % b);

        // Relational operators
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);

        // Assignment operators
        int x = 10;
        x %= 5;
        System.out.println(x);

        // Logical operators
        System.out.println(2 > 1 && 2 > 5);

        // Ternary operators
        int number = 10;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println(result);

        // Setting final keyword so user can't update update or change the things
        final float PI = 3.15f;
        System.out.print(PI);
    }
}