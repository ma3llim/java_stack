package base.solve_basic_string_problems;

public class CountVowels {
    public static void main(String[] args) {
        String name = "hello world";
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        int count = 0;

        for (char val : name.toCharArray()) {
            for (char c : vowels) {
                if (val == c) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
