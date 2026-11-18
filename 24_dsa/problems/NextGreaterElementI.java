package problems;

import java.util.Arrays;

public class NextGreaterElementI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        for (int i = 0; i < nums1.length; i++) {
            int position = 0;

            while (position < nums2.length && nums2[position] != nums1[i]) {
                position++;
            }

            for (int j = position + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 4, 1, 2 };
        int[] nums2 = new int[] { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

        int[] nums3 = new int[] { 2, 4 };
        int[] nums4 = new int[] { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(nextGreaterElement(nums3, nums4)));
    }
}
