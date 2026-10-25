package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static int[] topKFrequentBruteForce(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1; frequency >= 0 && index < k; frequency--) {
            if (buckets[frequency] != null) {
                for (int num : buckets[frequency]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));
        System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 }, 2)));
    }
}
