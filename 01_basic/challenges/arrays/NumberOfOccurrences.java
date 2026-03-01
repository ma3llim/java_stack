package arrays;

public class NumberOfOccurrences {
    public static void main() {
        int[] arrayNum = { 1, 2, 3, 4, 2, 7, 2, 9, 10 };
        int userInput = 2;
        int count = 0;
        for (int num : arrayNum) {
            if (num == userInput) {
                count++;
            }
        }
        System.out.println("Number of occurrences of " + userInput + " = " + count);
    }
}
