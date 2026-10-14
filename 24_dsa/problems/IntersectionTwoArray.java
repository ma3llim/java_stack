package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoArray {
    public static int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result.add(nums1[i]);
                }
            }
        }

        int[] answer = new int[result.size()];
        int index = 0;
        for (int num : result) {
            answer[index++] = num;
        }

        return answer;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] answer = new int[result.size()];
        int index = 0;
        for (int num : result) {
            answer[index++] = num;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
        System.out.println(Arrays.toString(intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4 })));
    }
}