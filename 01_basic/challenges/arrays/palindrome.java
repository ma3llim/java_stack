package arrays;

public class palindrome {
    public static void main(String[] args) {
        int[] arrayNum = { 1, 2, 3, 4, 3, 2, 1 };
        int start = 0, end = arrayNum.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (arrayNum[start] != arrayNum[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }
        System.out.println(isPalindrome ? "Given array is palindrome" : "Given array is a not palindrome");
    }
}
