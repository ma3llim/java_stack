package challenges.basic;

public class largestThreeNumber {
    public static void main(String[] args) {
        int nums[] = {3, 2, 5};
        int largestNumber = Math.max(nums[0], Math.max(nums[1],nums[2]));
        System.out.println("The largest number is: " + largestNumber);
    }
}
