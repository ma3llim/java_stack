package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashSet;

public class FindDuplicateElements {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 30, 20, 40 };
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : arr) {
            if (hashSet.contains(value)) {
                System.out.println(value);
            } else {
                hashSet.add(value);
            }
        }
    }
}
