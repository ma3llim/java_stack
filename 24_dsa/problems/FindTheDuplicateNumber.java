package problems;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
        System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
        System.out.println(findDuplicate(new int[] { 3, 3, 3, 3, 3 }));
    }
}
