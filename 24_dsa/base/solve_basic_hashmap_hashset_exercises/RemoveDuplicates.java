package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 30, 20, 40, 10 };
        HashSet<Integer> unique = new HashSet<>();

        for (int value : arr) {
            unique.add(value);
        }

        System.out.println(unique);
    }
}
