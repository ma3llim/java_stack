package problems;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        for (int[] a : firstList) {
            for (int[] b : secondList) {
                if (a[0] <= b[1] && b[0] <= a[1]) {
                    int start = Math.max(a[0], b[0]);
                    int end = Math.min(a[1], b[1]);

                    result.add(new int[] { start, end });
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList1 = new int[][] { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList1 = new int[][] { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        System.out.println(intervalIntersection(firstList1, secondList1));

        int[][] firstList2 = new int[][] { { 1, 3 }, { 5, 9 } };
        int[][] secondList2 = new int[][] {};
        System.out.println(intervalIntersection(firstList2, secondList2));
    }
}
