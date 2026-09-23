package base.solve_basic_string_problems;

public class CountCharachters {
    public static void main(String[] args) {
        String name = "Mohd Sameer";
        int length = 0;

        for (char i : name.toCharArray()) {
            length++;
        }
        System.out.println(length);
    }
}
