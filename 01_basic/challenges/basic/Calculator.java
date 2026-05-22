package challenges.basic;

public class Calculator {
    int add(int number1, int number2){
        return number1 + number2;
    }

    int subtract(int number1, int number2){
        return number1 - number2;
    }

    int multiply(int number1, int number2){
        return number1 * number2;
    }

    int divide(int number1, int number2){
        if (number2 == 0) {
            System.out.println("Cannot divide by zero");
            return 0;
        }

        return number1 / number2;
    }

    double add(double number1, double number2){
        return number1 + number2;
    }

    double subtract(double number1, double number2){
        return number1 - number2;
    }

    double multiply(double number1, double number2){
        return number1 * number2;
    }

    double divide(double number1, double number2){
        if (number2 == 0) {
            System.out.println("Cannot divide by zero");
            return 0;
        }

        return number1 / number2;
    }


    public static void main(String[] args){
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(5,10));
        System.out.println(calculator.add(5.1,10.9));
    }
}
