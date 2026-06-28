package easy;

import java.util.Arrays;
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

    public static void main(String[] args){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicateBruteForce(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate.containsDuplicateBruteForce(new int[]{1, 2, 3, 4}));
    }
}
