package problems;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
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
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 5, 6 };

        System.out.println(searchInsert(nums1, 5));
        System.out.println(searchInsert(nums1, 2));
        System.out.println(searchInsert(nums1, 7));
    }
}
