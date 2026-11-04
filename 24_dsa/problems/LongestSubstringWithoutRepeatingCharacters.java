package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> unqiue = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);

                if (unqiue.contains(ch)) {
                    break;
                }
                unqiue.add(ch);

                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> unique = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while (unique.contains(ch)) {
                unique.remove(s.charAt(left));
                left++;
            }
            unique.add(ch);

            int length = i - left + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
