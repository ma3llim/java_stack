package problems;

import java.util.Arrays;

public class MergeSortedArray {
    public static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            temp[m + i] = nums2[i];
        }

        Arrays.sort(temp);

        for (int i = 0; i < m + n; i++) {
            nums1[i] = temp[i];
        }
    }

    public static void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] temp = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }

            k++;
        }

        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        for (int l = 0; l < m + n; l++) {
            nums1[l] = temp[l];
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        int[] nums3 = { 1 };
        int[] nums4 = {};
        int[] nums5 = { 0 };
        int[] nums6 = { 1 };

        merge(nums1, 3, nums2, 3);
        merge(nums3, 1, nums4, 0);
        merge(nums5, 0, nums6, 1);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums5));
    }
}
