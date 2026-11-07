package problems;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public static int findDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }

            set.add(num);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
        System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
        System.out.println(findDuplicate(new int[] { 3, 3, 3, 3, 3 }));
    }
}
