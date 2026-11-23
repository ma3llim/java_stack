package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(map, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            return b.compareTo(a);
        });

        return list.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
        System.out.println(topKFrequent(
                new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
    }
}
