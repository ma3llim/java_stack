package recursive;

public class CheckPalindrome {
    public static boolean isPalindrome(String str) {
        return checkPalindrome(str, 0, str.length() - 1);
    }

    public static boolean checkPalindrome(String str, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return checkPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("hello"));
    }
}
