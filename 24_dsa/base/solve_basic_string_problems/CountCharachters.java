package base.solve_basic_string_problems;

public class CountCharachters {
    public static void main(String[] args) {
        String name = "Mohd Sameer";
        int length = 0;

        for (int i = 0; i < name.toCharArray().length; i++) {
            length++;
        }
        System.out.println(length);
    }
}
