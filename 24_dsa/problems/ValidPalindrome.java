package problems;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder clearn = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                clearn.append(Character.toLowerCase(ch));
            }
        }

        return clearn.toString().equals(clearn.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }
}
