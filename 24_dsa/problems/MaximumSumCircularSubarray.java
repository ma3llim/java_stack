package problems;

public class MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
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

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
        System.out.println(maxSubarraySumCircular(new int[] { 5, -3, 5 }));
        System.out.println(maxSubarraySumCircular(new int[] { -3, -2, -3 }));
    }
}
