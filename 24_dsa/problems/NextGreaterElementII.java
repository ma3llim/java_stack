package problems;

import java.util.Arrays;

public class NextGreaterElementII {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1;

            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;

                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 1 })));
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 3, 4, 3 })));
    }
}
