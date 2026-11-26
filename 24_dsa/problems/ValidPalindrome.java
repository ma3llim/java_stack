package problems;

public class ValidPalindrome {
    public static boolean checkPalindrome(String s, int left, int righ) {
        if (left >= righ) {
            return true;
        }

        if (!Character.isLetterOrDigit(s.charAt(left))) {
            return checkPalindrome(s, left + 1, righ);
        }

        if (!Character.isLetterOrDigit(s.charAt(righ))) {
            return checkPalindrome(s, left, righ - 1);
        }

        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(righ))) {
            return false;
        }

        return checkPalindrome(s, left + 1, righ - 1);
    }

    public static boolean isPalindromeBruteForce(String s) {
        StringBuilder clearn = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                clearn.append(Character.toLowerCase(ch));
            }
        }

        return clearn.toString().equals(clearn.reverse().toString());
    }

    public static boolean isPalindrome(String s) {
        return checkPalindrome(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}
