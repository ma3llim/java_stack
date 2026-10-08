package recursive;

public class PrintNumber {
    public static void printNumber(int nums) {
        if (nums == 1) {
            System.out.println(nums);
            return;
        }

        printNumber(nums - 1);
        System.out.println(nums);
    }

    public static void main(String[] args) {
        printNumber(5);
    }
}
