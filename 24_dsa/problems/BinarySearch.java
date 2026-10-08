package problems;

public class BinarySearch {
    public static int searchBruteForce(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static int searchBetter(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        int[] nums2 = { -1, 0, 3, 5, 9, 12 };

        System.out.println(searchBetter(nums1, 9));
        System.out.println(searchBetter(nums2, 2));
    }
}
