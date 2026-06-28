package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ContainsDuplicate {
    public boolean containsDuplicateBruteForce(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
    public boolean containsDuplicateBetterAppraoch(int[] nums){
        Arrays.sort(nums);
        for(int i=0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]) return true;
        }
        return false;
    }
    public boolean containsDuplicateOptimalApproach(int[] nums){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(nums[i])){
                return  true;
            }
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 1));
        }
        return false;
    }

    public static void main(String[] args){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicateOptimalApproach(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate.containsDuplicateOptimalApproach(new int[]{1, 2, 3, 4}));
    }
}
