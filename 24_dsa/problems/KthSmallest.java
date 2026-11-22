package problems;

import java.util.Arrays;

public class KthSmallest {
    public static int kthSmallestBruteForce(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(kthSmallestBruteForce(new int[] { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 }, 4));
        System.out.println(kthSmallestBruteForce(new int[] { 7, 10, 4, 3, 20, 15 }, 3));
    }
}
