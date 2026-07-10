package easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquaresBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return Arrays.stream(nums).sorted().toArray();
    }

    public int[] sortedSquareOptimal(int[] nums) {
        int left = 0, right = nums.length - 1, index = nums.length - 1;
        int[] result = new int[nums.length];

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[index] = leftSquare;
                left++;
            } else {
                result[index] = rightSquare;
                right--;
            }
            index--;
        }
        Arrays.stream(result).forEach(System.out::println);
        return result;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        System.out.println(squaresOfASortedArray.sortedSquareOptimal(new int[]{-4, -1, 0, 3, 10}));
        System.out.println(squaresOfASortedArray.sortedSquareOptimal(new int[]{-7, -3, 2, 3, 11}));
    }
}
