package problems;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            int ones = 0;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {
                    int currLen = j - i + 1;
                    maxLength = Math.max(maxLength, currLen);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] { 0, 1 }));
        System.out.println(findMaxLength(new int[] { 0, 1, 0 }));
        System.out.println(findMaxLength(new int[] { 0, 1, 1, 1, 1, 1, 0, 0, 0 }));
    }
}
