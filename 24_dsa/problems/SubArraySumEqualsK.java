package problems;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;

                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySumBetter(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            int needed = prefixSum - k;

            if (map.containsKey(needed)) {
                count += map.get(needed);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
        System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
    }
}
