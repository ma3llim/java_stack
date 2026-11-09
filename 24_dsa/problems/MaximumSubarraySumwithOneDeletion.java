package problems;

public class MaximumSubarraySumwithOneDeletion {
    public static int maximumSumBruteForce(int[] arr) {
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

    public static int maximumSum(int[] arr) {
        int result = arr[0];
        int noDelete = arr[0];
        int oneDelete = 0;

        for (int i = 1; i < arr.length; i++) {
            int prevNoDelete = noDelete;
            noDelete = Math.max(arr[i], noDelete + arr[i]);
            oneDelete = Math.max(prevNoDelete, oneDelete + arr[i]);

            result = Math.max(result, Math.max(noDelete, oneDelete));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] { 1, -2, 0, 3 }));
        System.out.println(maximumSum(new int[] { 1, -2, -2, 3 }));
        System.out.println(maximumSum(new int[] { -1, -1, -1, -1 }));
    }
}
