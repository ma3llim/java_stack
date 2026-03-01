package arrays;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 30 };
        int[] arr2 = { 40, 50, 60, 70, 80 };

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;
        int[] mergeArr = new int[arr1Length + arr2Length];

        for (int i = 0; i < arr1Length; i++) {
            mergeArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2Length; i++) {
            mergeArr[arr1Length + i] = arr2[i];
        }

        System.out.println(Arrays.toString(mergeArr));
    }
}
