package problems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insertBruteForce(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);

        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : list) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                int[] last = result.get(result.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean inserted = false;

        for (int[] interval : intervals) {
            if (!inserted && interval[0] >= newInterval[0]) {
                list.add(newInterval);
                inserted = true;
            }

            list.add(interval);
        }

        if (!inserted) {
            list.add(newInterval);
        }

        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] current = list.get(i);
            int[] previous = list.get(index);

            if (current[0] <= previous[1]) {
                previous[1] = Math.max(current[1], previous[1]);
            } else {
                index++;
                list.set(index, current);
            }
        }

        return list.subList(0, index + 1).toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = new int[][] { { 1, 3 }, { 6, 9 } };
        int[] newInterval1 = new int[] { 2, 5 };
        System.out.println(insert(intervals1, newInterval1));

        int[][] intervals2 = new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval2 = new int[] { 4, 8 };
        System.out.println(insert(intervals2, newInterval2));
    }
}
