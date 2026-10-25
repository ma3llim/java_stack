package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutiveBruteForce(int[] nums) {
        int longest = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            count = 1;

            while (linearSearch(nums, current + 1) == true) {
                current++;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    public static boolean linearSearch(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }

    public static int longestConsecutiveBetter(int[] nums) {
        int longest = 1;
        int currentCount = 1;

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            longest = Math.max(longest, currentCount);
        }

        return longest;
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    count++;
                    current++;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
        System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
        System.out.println(longestConsecutive(new int[] { 1, 0, 1, 2 }));
    }
}
