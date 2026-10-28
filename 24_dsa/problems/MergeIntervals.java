package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] mergeBetter(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][i]);
            } else {
                result.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[] { start, end });

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int index = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i][1]) {
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                index++;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
        }

        return Arrays.copyOf(intervals, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
        System.out.println(Arrays.toString(merge(new int[][] { { 1, 4 }, { 4, 5 } })));
        System.out.println(Arrays.toString(merge(new int[][] { { 4, 7 }, { 1, 4 } })));
    }
}
