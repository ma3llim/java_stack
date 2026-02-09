package arrays;

import java.util.Arrays;

public class newArrayDeleting {
    public static void main(String[] args) {
        int[] arrayNum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int removeNum = 2, count = 0, index = 0;

        for (int num : arrayNum) {
            if (num != removeNum) {
                count++;
            }
        }
        int[] newArr = new int[count];
        for (int num : arrayNum) {
            if (num != removeNum) {
                newArr[index++] = num;
            }
        }
        System.out.println(Arrays.toString(newArr));
    }
}
