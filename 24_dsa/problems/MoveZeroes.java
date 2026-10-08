package problems;

import java.util.Arrays;

public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, 1, 0, 3, 12 };
        int[] nums2 = { 0 };

        System.out.println(Arrays.toString(moveZeroes(nums1)));
        System.out.println(Arrays.toString(moveZeroes(nums2)));
    }
}
