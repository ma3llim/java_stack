public class Factorial {
  public static void main() {
    int result = factorialNumber(10);
    System.out.println("The Factorial is " + result);
  }

  public static int factorialNumber(int number) {
    int result = 1;
    if (number < 2) {
      return 1;
    }
    for (int i = 1; i <= number; i++) {
      result *= i;
    }
    return result;
  }
}
