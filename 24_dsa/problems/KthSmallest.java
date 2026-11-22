package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthSmallestBruteForceBruteForce(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static int kthSmallestBruteForce(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(kthSmallestBruteForce(new int[] { 10, 5, 4, 3, 48, 6, 2, 33, 53, 10 }, 4));
        System.out.println(kthSmallestBruteForce(new int[] { 7, 10, 4, 3, 20, 15 }, 3));
    }
}
