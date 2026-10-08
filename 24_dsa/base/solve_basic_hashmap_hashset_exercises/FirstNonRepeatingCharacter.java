package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "aabbcde";
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char value : str.toCharArray()) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }

        for (char value : str.toCharArray()) {
            if (hashMap.get(value) == 1) {
                System.out.println(value);
                break;
            }
        }
    }
}
