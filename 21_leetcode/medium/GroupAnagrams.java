package medium;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagramsBruteForce(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length - 1; j++) {
                if (!visited[j] && isAnagrams(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }

    public boolean isAnagrams(String s1, String s2) {
        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();
        Arrays.sort(charS1);
        Arrays.sort(charS2);

        return Arrays.equals(charS1, charS2);
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagramsBruteForce(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        groupAnagrams.groupAnagramsBruteForce(new String[]{""});
//        groupAnagrams.groupAnagramsBruteForce(new String[]{"a"});
    }
}
