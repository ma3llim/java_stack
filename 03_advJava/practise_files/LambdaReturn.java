package practise_files;

@FunctionalInterface
interface utils {
    int add(int num1, int num2);
}

public class LambdaReturn {
    public static void main(String[] args) {
        utils obj = (int num1, int num2) -> num1 + num2;
        int result = obj.add(10, 20);
        System.out.println("Sum of both sum: " + result);
    }
}
