package recursive;

public class SumOfNumber {
    public static int sumofNumber(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sumofNumber(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumofNumber(5));
    }
}
