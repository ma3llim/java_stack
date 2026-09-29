package search.ImplementBinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
        int target1 = 60;
        int target2 = 25;
        int target3 = 20;

        System.out.println(binarySearch(arr, target1));
        System.out.println(binarySearch(arr, target2));
        System.out.println(binarySearch(arr, target3));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target == arr[middle]) {
                return middle;
            } else if (target > arr[middle]) {
                left = middle + 1;
            } else if (target < arr[middle]) {
                right = middle - 1;
            }
        }

        return -1;
    }
}
