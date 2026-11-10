package problems;

public class MaximumAbsoluteSumofAnySubarray {
    public static int maxAbsoluteSumBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, Math.abs(sum));
            }
        }
        return max;
    }

    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxAbsoluteSum = Math.abs(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            minSum = Math.min(nums[i], minSum + nums[i]);
            maxAbsoluteSum = Math.max(maxAbsoluteSum, Math.max(Math.abs(maxSum), Math.abs(minSum)));
        }

        return maxAbsoluteSum;
    }

    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[] { 1, -3, 2, 3, -4 }));
        System.out.println(maxAbsoluteSum(new int[] { 2, -5, 1, -4, 3, -2 }));
    }
}
