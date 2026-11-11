package problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    public static int subarraysDivByKBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            int remainder = sum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
        System.out.println(subarraysDivByK(new int[] { 5 }, 9));
    }
}
