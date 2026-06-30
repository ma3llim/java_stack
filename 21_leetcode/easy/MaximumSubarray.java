package easy;

public class MaximumSubarray {
    public int maxSubArrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                int currentSum = 0;
                for (int i = start; i <= end; i++) {
                    currentSum += nums[i];
                }
                maxSum = Math.max(currentSum, maxSum);
            }

        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArrayBruteForce(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray.maxSubArrayBruteForce(new int[]{1}));
        System.out.println(maximumSubarray.maxSubArrayBruteForce(new int[]{5, 4, -1, 7, 8}));
    }
}
