package base.solve_basic_string_problems;

public class CountSpecificCharacter {
    public static void main(String[] args) {
        String name = "banana";
        char target = 'a';
        int count = 0;

        for (char value : name.toCharArray()) {
            if (value == target) {
                count++;
            }
        }

        System.out.println(count);
    }
}
