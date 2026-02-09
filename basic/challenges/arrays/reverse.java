package arrays;

import java.util.Arrays;

public class reverse {
    public static void main(String[] args) {
        int[] arrayNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int start = 0, end = arrayNum.length - 1;

        while (start < end) {
            int temp = arrayNum[start];
            arrayNum[start] = arrayNum[end];
            arrayNum[end] = temp;

            start++;
            end--;
        }

        System.err.println("Reverse Array: " + Arrays.toString(arrayNum));
    }
}
