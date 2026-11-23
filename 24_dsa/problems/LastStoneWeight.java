package problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();

            int smash = first - second;

            if (smash > 0) {
                pq.add(smash);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
        System.out.println(lastStoneWeight(new int[] { 1 }));
    }
}
