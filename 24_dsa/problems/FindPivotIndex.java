package problems;

public class FindPivotIndex {
    public static int pivotIndexBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 3, 6, 5, 6 };
        int[] nums2 = { 1, 2, 3 };
        int[] nums3 = { 2, 1, -1 };

        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
        System.out.println(pivotIndex(nums3));
    }
}
