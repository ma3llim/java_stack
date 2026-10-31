package problems;

import java.util.Arrays;

public class SquaresofSortedArray {
    public static int[] sortedSquaresBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] negatives = new int[n];
        int[] positives = new int[n];
        int negativeSize = 0;
        int positiveSize = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negatives[negativeSize++] = nums[i] * nums[i];
            } else {
                positives[positiveSize++] = nums[i] * nums[i];
            }
        }

        int negativeIndex = negativeSize - 1;
        int positiveIndex = 0;
        int[] result = new int[nums.length];
        int k = 0;

        while (negativeIndex >= 0 && positiveIndex < positiveSize) {
            if (negatives[negativeIndex] < positives[positiveIndex]) {
                result[k] = negatives[negativeIndex];
                negativeIndex--;
            } else {
                result[k] = positives[positiveIndex];
                positiveIndex++;
            }
            k++;
        }

        while (negativeIndex >= 0) {
            result[k] = negatives[negativeIndex];
            negativeIndex--;
            k++;
        }

        while (positiveIndex < positiveSize) {
            result[k] = positives[positiveIndex];
            positiveIndex++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
        System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
    }
}
