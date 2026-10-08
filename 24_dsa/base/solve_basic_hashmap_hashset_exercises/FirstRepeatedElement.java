package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashSet;

public class FirstRepeatedElement {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 20, 40, 30 };
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : arr) {
            if (hashSet.contains(value)) {
                System.out.println(value);
                break;
            } else {
                hashSet.add(value);
            }
        }
    }
}
