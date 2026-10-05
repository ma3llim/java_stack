package problems;

import java.util.Arrays;

public class RotateArray {
    public static void rotateBrute(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            int last = nums[n - 1];

            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }

            nums[0] = last;
        }
    }

    public static void rotateBetter(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] results = new int[n];

        for (int i = 0; i < n; i++) {
            results[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = results[i];
        }
    }

    public static void rotateOptimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reserver(nums, 0, n - 1);
        reserver(nums, 0, k - 1);
        reserver(nums, k, n - 1);
    }

    public static void reserver(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] nums2 = { -1, -100, 3, 99 };

        rotateOptimal(nums1, 3);
        rotateOptimal(nums2, 2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
