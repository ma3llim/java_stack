package problems;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static int getSumOfSquare(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static boolean isHappyBruteForce(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);
            n = getSumOfSquare(n);
        }
        return true;
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getSumOfSquare(slow);
            fast = getSumOfSquare(fast);
            fast = getSumOfSquare(fast);

            if (slow == 1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
