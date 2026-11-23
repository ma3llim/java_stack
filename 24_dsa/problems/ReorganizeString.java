package problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int maxFreq = Collections.max(map.values());

        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        StringBuilder str = new StringBuilder();

        while (pq.size() >= 2) {
            char first = pq.poll();
            char second = pq.poll();

            str.append(first);
            str.append(second);

            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);

            if (map.get(first) > 0) {
                pq.add(first);
            }

            if (map.get(second) > 0) {
                pq.add(second);
            }
        }

        if (!pq.isEmpty()) {
            str.append(pq.poll());
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}
