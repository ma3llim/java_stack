package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashSet;

public class CommonElement {
    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 30, 40 };
        int[] arr2 = { 30, 40, 50, 60 };
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : arr1) {
            hashSet.add(value);
        }

        for (int value : arr2) {
            if (hashSet.contains(value)) {
                System.out.println(value);
            }
        }
    }
}
