public class Multiplication {
  public static void main(String[] args) {
    multiple(5);
  }

  public static void multiple(int num) {
    for (int i = 1; i <= 10; i++) {
      System.out.println(num + " x " + i + " = " + (i * num));
    }
  }
}
