package problems;

import java.util.Stack;

class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

public class RemoveAllAdjacentDuplicatesinStringII {
    public static String removeDuplicatesBruteForce(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        boolean removed = true;

        while (removed) {
            removed = false;
            for (int i = 0; i <= sb.length(); i++) {
                int count = 1;

                for (int j = i + 1; j < sb.length(); j++) {
                    if (sb.charAt(i) == sb.charAt(j)) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count >= k) {
                    sb.delete(i, i + k);
                    removed = true;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == ch) {
                stack.peek().count++;
            } else {
                stack.push(new Pair(ch, 1));
            }

            if (!stack.isEmpty() && stack.peek().count == k) {
                stack.pop();
            }

        }

        for (Pair pair : stack) {
            result.append(String.valueOf(pair.ch).repeat(pair.count));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
