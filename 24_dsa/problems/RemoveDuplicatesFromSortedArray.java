package problems;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicatesBruteForce(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int index = 0;
        for (int num : set) {
            nums[index] = num;
            index++;
        }

        return set.size();
    }

    public static int removeDuplicates(int[] nums) {
        int unqiue = 1;
        int current = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                nums[current + 1] = nums[i];
                current++;
                unqiue++;
            }
        }

        return unqiue;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
        System.out.println(removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }
}
