package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagramsBruteForce(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = new String(strChar);

            result.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(result.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            String key = getFrequencyString(str);

            result.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(result.values());
    }

    public static String getFrequencyString(String str) {
        int[] freq = new int[26];

        for (char chr : str.toCharArray()) {
            freq[chr - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        char c = 'a';

        for (int i : freq) {
            builder.append(c);
            builder.append(i);
            c++;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
