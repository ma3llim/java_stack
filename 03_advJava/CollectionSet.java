import java.util.HashSet;
import java.util.Set;

public class CollectionSet {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);

        for (int n : nums) {
            System.out.println(n);
        }
    }
}