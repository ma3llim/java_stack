package problems;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicatesBruteForce(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean removed = true;

        while (removed) {
            removed = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.delete(i, i + 2);
                    removed = true;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character character : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == character) {
                stack.pop();
            } else {
                stack.add(character);
            }
        }
        StringBuilder result = new StringBuilder();

        for (Character character : stack) {
            result.append(character);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "abbaca";
        String s2 = "azxxzy";

        System.out.println(removeDuplicates(s1));
        System.out.println(removeDuplicates(s2));
    }
}
