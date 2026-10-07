package problems;

import java.util.Arrays;

public class SortAnArray {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;

        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);

        merge(arr, left, middle, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int low = left;
        int high = mid + 1;
        int index = 0;

        int[] temp = new int[right - left + 1];

        while (low <= mid && high <= right) {
            if (arr[low] <= arr[high]) {
                temp[index] = arr[low];
                low++;
            } else {
                temp[index] = arr[high];
                high++;
            }
            index++;
        }

        while (low <= mid) {
            temp[index] = arr[low];
            low++;
            index++;
        }

        while (high <= right) {
            temp[index] = arr[high];
            high++;
            index++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 5, 2, 3, 1 };
        int[] nums2 = { 5, 1, 1, 2, 0, 0 };

        mergeSort(nums1, 0, nums1.length - 1);
        mergeSort(nums2, 0, nums2.length - 1);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}