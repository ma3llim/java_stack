package problems;

public class MaximumSumCircularSubarray {
    public static int maxSubarraySumCircularBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = 0; j < n; j++) {
                currentSum += nums[(i + j) % n];
                max = Math.max(max, currentSum);
            }
        }

        return max;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = 0;
        int currMax = 0;
        int currMin = 0;
        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        if (maxSum < 0) {
            return maxSum;
        }

        int circuleSum = totalSum - minSum;
        return Math.max(maxSum, circuleSum);
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
        System.out.println(maxSubarraySumCircular(new int[] { 5, -3, 5 }));
        System.out.println(maxSubarraySumCircular(new int[] { -3, -2, -3 }));
    }
}
