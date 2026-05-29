package Strings.programs;

public class Palindrome {
    String string;
    String reverseString;

    Palindrome(String string){
        this.string = string;
        reverseString = new StringBuilder(string).reverse().toString();
    }

    public void isPalindrome() {
        if(string.equals(reverseString)) {
            System.out.println("String is a palindrome");
        }else {
            System.out.println("String is not palindrome");
        }
    }
}
