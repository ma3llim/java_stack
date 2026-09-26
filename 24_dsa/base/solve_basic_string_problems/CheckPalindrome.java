package base.solve_basic_string_problems;

public class CheckPalindrome {
    public static void main(String[] args) {
        String name = "madam";
        char[] charName = name.toCharArray();
        StringBuilder reverseString = new StringBuilder();

        for (int i = charName.length - 1; i >= 0; i--) {
            reverseString.append(charName[i]);
        }

        if (name.equalsIgnoreCase(reverseString.toString())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}
