package problems;

import java.util.Arrays;

public class SortColors {
    public static void sortColorsBruteForce(int[] nums) {
        Arrays.sort(nums);
    }

    public static void sortColorsBetter(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int index = 0;

        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else if (num == 2) {
                count2++;
            }
        }

        while (count0 > 0) {
            nums[index] = 0;
            count0--;
            index++;
        }

        while (count1 > 0) {
            nums[index] = 1;
            count1--;
            index++;
        }

        while (count2 > 0) {
            nums[index] = 2;
            count2--;
            index++;
        }
    }

    public static void sortColors(int[] nums) {
        int low = 0, middle = 0, high = nums.length - 1;

        while (middle <= high) {
            if (nums[middle] == 0) {
                int temp = nums[middle];
                nums[middle] = nums[low];
                nums[low] = temp;

                low++;
                middle++;
            } else if (nums[middle] == 1) {
                middle++;
            } else if (nums[middle] == 2) {
                int temp = nums[middle];
                nums[middle] = nums[high];
                nums[high] = temp;

                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 0, 2, 1, 1, 0 };
        int[] nums2 = { 2, 0, 1 };

        sortColors(nums1);
        sortColors(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }
}
