package problems;

public class RemoveElemenet {
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 2, 2, 3 };
        int val1 = 3;
        int[] arr2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val2 = 2;

        System.out.println(removeElement(arr1, val1));
        System.out.println(removeElement(arr2, val2));
    }
}
