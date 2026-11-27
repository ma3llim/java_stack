package problems;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        if (digits.isEmpty()) {
            return results;
        }

        String[] mapping = {
                "", "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), mapping, results);

        return results;
    }

    private static void backtrack(
            String digits,
            int index,
            StringBuilder current,
            String[] mapping,
            List<String> result) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);

            backtrack(digits, index + 1, current, mapping, result);

            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
    }
}
