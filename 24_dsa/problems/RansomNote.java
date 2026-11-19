package problems;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static boolean canConstructBruteForce(String ransomNote, String magazine) {
        boolean[] used = new boolean[magazine.length()];

        for (int i = 0; i < ransomNote.length(); i++) {
            boolean found = false;

            for (int j = 0; j < magazine.length(); j++) {
                if (ransomNote.charAt(i) == magazine.charAt(j) && !used[j]) {
                    found = true;
                    used[j] = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> needed = new HashMap<>();

        for (char ch : ransomNote.toCharArray()) {
            have.put(ch, have.getOrDefault(ch, 0) + 1);
        }

        for (char ch : magazine.toCharArray()) {
            needed.put(ch, needed.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (needed.getOrDefault(ch, 0) < have.get(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
