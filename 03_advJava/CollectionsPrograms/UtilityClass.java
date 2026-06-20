package CollectionsPrograms;

import java.util.*;

public class UtilityClass {
    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>(Arrays.asList(40, 10, 30, 20));


        // Collections.sort(nums);
        // Collections.sort(nums, Comparator.reverseOrder());
        // Collections.reverse(nums);
        // Collections.shuffle(nums);
        // System.out.println(Collections.max(nums));
        // System.out.println(Collections.min(nums));
        System.out.println(Collections.frequency(nums, 10));
    }
}
