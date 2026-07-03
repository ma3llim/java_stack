package easy;

public class ValidPalindrome {
    public boolean isPalindromeBruteForce(String s) {
        String clearnString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedString = new StringBuilder(clearnString).reverse().toString();
        return clearnString.equals(reversedString);
    }

    public boolean isPalindromeOptimal(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.isLowerCase(s.charAt(left)) != Character.isLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindromeOptimal("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindromeOptimal("race a car"));
    }
}
