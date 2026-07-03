package easy;

import java.util.Arrays;

public class ReverseString {
    public void reverseStringBruteForce(char[] s) {
        String reverseString = new StringBuilder(new String(s)).reverse().toString();
        for (int i = 0; i < s.length; i++) {
            s[i] = reverseString.charAt(i);
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseStringBruteForce(new char[]{'h', 'e', 'l', 'l', 'o'}));
    }
}
