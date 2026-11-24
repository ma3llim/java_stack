package problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < profits.length; i++) {
            minHeap.add(new int[] { capital[i], profits[i] });
        }

        for (int i = 0; i < k; i++) {

            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                int[] project = minHeap.poll();

                maxHeap.add(project[1]);
            }

            if (maxHeap.isEmpty()) {
                break;
            }

            w += maxHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));
        System.out.println(findMaximizedCapital(3, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 2 }));
    }
}
