package problems;

import java.util.Arrays;

public class MissingNumber {
    public static int missingNumberBruteForce(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return i;
            }
        }

        return -1;
    }

    public static int missingNumberBetter(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    public static int missingNumberWithSum(int[] nums) {
        int n = nums.length;
        int execpetedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return execpetedSum - actualSum;
    }

    public static int missingNumber(int[] nums) {
        int xor = nums.length;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] { 3, 0, 1 }));
        System.out.println(missingNumber(new int[] { 0, 1 }));
        System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }
}
