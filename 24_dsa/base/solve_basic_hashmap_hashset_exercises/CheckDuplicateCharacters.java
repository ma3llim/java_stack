package base.solve_basic_hashmap_hashset_exercises;

import java.util.HashSet;

public class CheckDuplicateCharacters {
    public static void main(String[] args) {
        String str = "programming";
        HashSet<Character> hashSet = new HashSet<>();

        for (char value : str.toCharArray()) {
            if (hashSet.contains(value)) {
                System.out.println(true);
                break;
            } else {
                hashSet.add(value);
            }
        }
    }
}
