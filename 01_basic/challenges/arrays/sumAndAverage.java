package arrays;

public class sumAndAverage {
    public static void main(String[] args) {
        int[] arraysNumber = { 1, 2, 3, 4, 5, };
        int sum = 0, average = 0;

        for (int i = 0; i < arraysNumber.length; i++) {
            sum += i;
        }
        average = sum / arraysNumber.length;
        System.out.println("The Sum of arrays: " + sum);
        System.out.println("The Average of arrays: " + average);
    }
}
