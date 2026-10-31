package problems;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosestBruteForce(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        int minDifferent = Math.abs(closestSum - target);

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int different = Math.abs(sum - target);
                    if (different < minDifferent) {
                        minDifferent = different;
                        closestSum = sum;
                    }
                }
            }

        }

        return closestSum;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int different = Math.abs(sum - target);
                int closestDifferent = Math.abs(closestSum - target);

                if (different < closestDifferent) {
                    closestSum = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
        System.out.println(threeSumClosest(new int[] { 0, 0, 0 }, 1));
    }
}
