package problems;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
    public static int firstUniqCharBruteForce(String s) {
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }
}
