package problems;

public class MaximumProductSubarray {
    public static int maxProductBruteForce(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value1 = nums[i];
            int value2 = maxProduct * nums[i];
            int value3 = minProduct * nums[i];

            maxProduct = Math.max(value1, Math.max(value2, value3));
            minProduct = Math.min(value1, Math.min(value2, value3));
            result = Math.max(result, Math.max(maxProduct, minProduct));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
        System.out.println(maxProduct(new int[] { -2, 0, -1 }));
    }
}
