package problems;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRangeBruteForce(int[] nums, int target) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (first == -1) {
                    first = i;
                }

                last = i;
            }
        }

        return new int[] { first, last };
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] { first, last };
    }

    public static int findFirst(int[] nums, int target) {
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target == nums[middle]) {
                answer = middle;
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            }
        }

        return answer;
    }

    public static int findLast(int[] nums, int target) {
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target == nums[middle]) {
                answer = middle;
                left = middle + 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else if (target < nums[middle]) {
                right = middle - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
        System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
    }
}
