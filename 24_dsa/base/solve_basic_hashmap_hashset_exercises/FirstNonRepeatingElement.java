package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashMap;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 10, 30, 20, 40 };
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int value : arr) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }

        for (int val : arr) {
            if (hashMap.get(val) == 1) {
                System.out.println(val);
                break;
            }
        }

    }
}
