package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 2, 11, 15, 7 };
        int target = 9;
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : arr) {
            int needed = target - value;

            if (hashSet.contains(needed)) {
                System.out.println(true);
                break;
            }

            hashSet.add(value);
        }
    }
}
