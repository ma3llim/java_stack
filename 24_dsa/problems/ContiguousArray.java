package problems;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static int findMaxLengthBruteForce(int[] nums) {
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

    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (sum == 0) {
                maxLength = i + 1;
            }

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
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
