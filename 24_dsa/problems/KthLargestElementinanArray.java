package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public static int findKthLargestBruteForce(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    }
}
