package problems;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberofBalloons {
    public static int maxNumberOfBalloonsBruteForce(String text) {
        StringBuilder sb = new StringBuilder(text);
        String target = "ballon";
        int count = 0;

        while (true) {
            boolean found = true;
            for (char ch : target.toCharArray()) {
                int index = sb.indexOf(String.valueOf(ch));

                if (index == -1) {
                    found = false;
                    break;
                }

                sb.deleteCharAt(index);
            }

            if (!found) {
                break;
            }

            count++;
        }
        return count;
    }

    public static int maxNumberOfBalloons(String text) {
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char ch : text.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        int b = hashMap.getOrDefault('b', 0);
        int a = hashMap.getOrDefault('a', 0);
        int l = hashMap.getOrDefault('l', 0) / 2;
        int o = hashMap.getOrDefault('o', 0) / 2;
        int n = hashMap.getOrDefault('n', 0);

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("leetcode"));
    }
}
