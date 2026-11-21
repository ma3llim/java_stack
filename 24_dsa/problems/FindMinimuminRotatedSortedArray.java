package problems;

public class FindMinimuminRotatedSortedArray {
    public static int findMinBruteForce(int[] nums) {
        int min = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }

        return nums[res];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        System.out.println(findMin(new int[] { 11, 13, 15, 17 }));
    }
}
