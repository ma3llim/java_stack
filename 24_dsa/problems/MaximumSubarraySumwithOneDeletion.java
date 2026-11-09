package problems;

public class MaximumSubarraySumwithOneDeletion {
    public static int maximumSum(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);

                for (int k = i; k <= j; k++) {
                    int deleteSum = sum - arr[k];

                    if (i != j) {
                        max = Math.max(max, deleteSum);
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] { 1, -2, 0, 3 }));
        System.out.println(maximumSum(new int[] { 1, -2, -2, 3 }));
        System.out.println(maximumSum(new int[] { -1, -1, -1, -1 }));
    }
}
