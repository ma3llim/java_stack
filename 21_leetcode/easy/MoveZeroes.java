package easy;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroesBetter(int[] nums) {
        int[] temp = new int[nums.length];
        int tempIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp[tempIndex] = nums[i];
                tempIndex++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public void moveZeroesOptimal(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
        }
    }


    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroesOptimal(new int[]{0, 1, 0, 3, 12});
        moveZeroes.moveZeroesOptimal(new int[]{0});
    }
}
