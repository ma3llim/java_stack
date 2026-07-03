package easy;

import java.util.Arrays;

public class ReverseString {
    public void reverseStringBruteForce(char[] s) {
        String reverseString = new StringBuilder(new String(s)).reverse().toString();
        for (int i = 0; i < s.length; i++) {
            s[i] = reverseString.charAt(i);
        }
    }

    public void reverseStringBetter(char[] s) {
        char[] result = new char[s.length];
        int j = 0;
        
        for (int i = s.length - 1; i >= 0; i--) {
            result[j] = s[i];
            j++;
        }
        for (int i = 0; i < s.length; i++) {
            s[i] = result[i];
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseStringBetter(new char[]{'h', 'e', 'l', 'l', 'o'}));
    }
}
