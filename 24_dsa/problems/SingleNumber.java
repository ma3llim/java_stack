package problems;

import java.util.HashMap;
import java.util.Map;

class SingleNumber {
    public static int singleNumberBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return nums[i];
            }
        }

        return -1;
    }

    public static int singleNumberBetter(int[] nums) {
        Map<Integer, Integer> hasMap = new HashMap<>();

        for (int num : nums) {
            hasMap.put(num, hasMap.getOrDefault(num, 0) + 1);
        }

        for (int num : hasMap.keySet()) {
            if (hasMap.get(num) == 1) {
                return num;
            }
        }

        for (int num : hasMap.keySet()) {
            if (hasMap.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static int singleNumber(int[] nums) {
        int xorNum = 0;

        for (int num : nums) {
            xorNum = xorNum ^ num;
        }

        return xorNum;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] { 2, 2, 1 }));
        System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));
        System.out.println(singleNumber(new int[] { 1 }));
    }
}