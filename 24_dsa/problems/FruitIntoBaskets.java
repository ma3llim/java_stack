package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitIntoBaskets {
    public static int totalFruitBruteForce(int[] fruits) {
        int maxLength = 0;
        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> unqine = new HashSet<>();

            for (int j = i; j < fruits.length; j++) {
                unqine.add(fruits[j]);
                if (unqine.size() > 2) {
                    break;
                }

                int length = j - i + 1;
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static int totalFruit(int[] fruits) {
        int left = 0;
        int maxLength = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            hashMap.put(fruit, hashMap.getOrDefault(fruit, 0) + 1);

            while (hashMap.size() > 2) {
                int leftFruit = fruits[left];

                hashMap.put(leftFruit, hashMap.get(leftFruit) - 1);

                if (hashMap.get(leftFruit) == 0) {
                    hashMap.remove(leftFruit);
                }

                left++;
            }

            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] { 1, 2, 1 }));
        System.out.println(totalFruit(new int[] { 0, 1, 2, 2 }));
        System.out.println(totalFruit(new int[] { 1, 2, 3, 2, 2 }));
    }
}
