package base.solve_basic_string_problems;

public class ReverseString {
    public static void main(String[] args) {
        String name = "hello";
        char[] nameArray = name.toCharArray();

        for (int i = nameArray.length - 1; i >= 0; i--) {
            System.out.print(nameArray[i]);
        }
    }
}
