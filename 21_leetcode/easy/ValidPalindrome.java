package easy;

public class ValidPalindrome {
    public boolean isPalindromeBruteForce(String s) {
        String clearnString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedString = new StringBuilder(clearnString).reverse().toString();
        return clearnString.equals(reversedString);
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindromeBruteForce("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindromeBruteForce("race a car"));
    }
}
