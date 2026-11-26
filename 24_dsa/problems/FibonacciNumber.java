package problems;

public class FibonacciNumber {
    public static int fibBruteForce(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static int fibBetter(int n) {
        if (n <= 1) {
            return n;
        }

        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int i = 0;
        int j = 1;

        for (int k = 2; k <= n; k++) {
            int curr = i + j;

            i = j;
            j = curr;
        }

        return j;
    }

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }
}
