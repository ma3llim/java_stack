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

    public int maxSubArrayBetterForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                maxSum = Math.max(currentSum, maxSum);
            }

        }
        return maxSum;
    }

    public int maxSubArrayOptimalForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArrayBetterForce(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maximumSubarray.maxSubArrayBetterForce(new int[]{1}));
        System.out.println(maximumSubarray.maxSubArrayBetterForce(new int[]{5, 4, -1, 7, 8}));
    }
}
