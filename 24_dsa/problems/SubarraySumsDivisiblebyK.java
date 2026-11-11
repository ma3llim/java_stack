package problems;

public class SubarraySumsDivisiblebyK {
    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
        System.out.println(subarraysDivByK(new int[] { 5 }, 9));
    }
}
