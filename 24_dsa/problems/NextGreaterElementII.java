package problems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static int[] nextGreaterElementsBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1;

            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;

                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    break;
                }
            }
        }

        return result;
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        Arrays.fill(result, -1);

        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];

            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }

            if (i < n) {
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                }
            }

            stack.push(current);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 1 })));
        System.out.println(Arrays.toString(nextGreaterElements(new int[] { 1, 2, 3, 4, 3 })));
    }
}
