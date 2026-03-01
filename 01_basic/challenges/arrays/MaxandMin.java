package arrays;

public class MaxandMin {
    public static void main(String[] args) {
        int[] arrayNum = { 1, 2, 3, 4, 2, 7, 2, 9, 10 };
        int min = arrayNum[0], max = arrayNum[0];
        for (int num : arrayNum) {
            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}
