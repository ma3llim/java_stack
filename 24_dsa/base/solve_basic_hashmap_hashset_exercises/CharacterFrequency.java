package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashMap;

public class CharacterFrequency {
    public static void main(String[] args) {
        String str = "programming";
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char val : str.toCharArray()) {
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        }

        System.out.println(hashMap);
    }
}
