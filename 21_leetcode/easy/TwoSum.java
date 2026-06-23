package easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
   public int[] twoSumBruteForce(int[] nums, int target){
       for(int i = 0; i < nums.length; i++){
           for(int j = i + 1; j < nums.length; j++){
               if(nums[i] + nums[j] == target){
                   return new int[]{i, j};
               }
           }
       }
       return new int[]{};
   }

   public int[] twoSumOptimal(int[] nums, int target){
       HashMap<Integer, Integer> hashMap = new HashMap<>();
       for(int i = 0; i < nums.length; i++){
           int complient = target - nums[i];
           if(hashMap.containsKey(complient)){
               return new int[]{hashMap.get(complient), i};
           }
           hashMap.put(nums[i],i);
       }
       return new int[]{};
   }

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();

        System.out.println(Arrays.toString(twoSum.twoSumOptimal(nums, target)));
    }
}
