package problems;

import java.util.Arrays;

public class BuildArrayfromPermutation {
    public static int[] buildArrayBruteForce(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }

    public static int[] buildArrayBetter(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] / n;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, 2, 1, 5, 3, 4 };
        int[] nums2 = { 5, 0, 1, 2, 3, 4 };

        System.out.println(Arrays.toString(buildArrayBetter(nums1)));
        System.out.println(Arrays.toString(buildArrayBetter(nums2)));
    }
}
