package easy;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagramBruteForce(String s, String t) {
        if (s.length() != t.length()) return false;

        boolean[] used = new boolean[t.length()];

        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < t.length(); j++) {
                if (!used[j] && s.charAt(i) == t.charAt(j)) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }
        return true;
    }

    public boolean isAnagramBetterApproach(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    public boolean isAnagramOptimalApproach(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> charCounter = new HashMap<>();

        for (char sChar : s.toCharArray()) {
            charCounter.put(sChar, charCounter.getOrDefault(sChar, 0) + 1);
        }

        for (char tChar : t.toCharArray()) {
            charCounter.put(tChar, charCounter.getOrDefault(tChar, 0) - 1);
        }

        for (var keyPair : charCounter.entrySet()) {
            if (keyPair.getValue() != 0) return false;
        }

        return true;
    }

    public boolean isAnagramMostOptimalApproach(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charCounter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charCounter[t.charAt(i) - 'a']--;
        }

        for (int num : charCounter) {
            if (num != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagramMostOptimalApproach("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagramMostOptimalApproach("rat", "car"));
    }
}

