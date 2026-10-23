package problems;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElementBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int counter = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    counter++;
                }
            }

            if (counter > nums.length / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    public static int majorityElementBetter(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }

    public static int majorityElement(int[] nums) {
        int counter = 0;
        int candidate = 0;

        for (int i = 0; i < nums.length; i++) {
            if (counter == 0) {
                candidate = nums[i];
                counter = 1;
            } else if (candidate == nums[i]) {
                counter++;
            } else {
                counter--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 3, 2, 3 }));
        System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
        System.out.println(majorityElement(new int[] { 1 }));
    }
}
