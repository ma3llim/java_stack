package problems;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacementBruteForce(String s, int k) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            int maxFreq = 0;

            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freq[ch - 'A']++;

                maxFreq = Math.max(maxFreq, freq[ch - 'A']);

                int windowSize = j - i + 1;
                int replacement = windowSize - maxFreq;

                if (replacement <= k) {
                    maxLength = Math.max(maxLength, windowSize);
                } else {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;

            while (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                windowSize = right - left + 1;
            }

            maxLength = Math.max(maxFreq, windowSize);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
