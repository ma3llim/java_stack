import java.util.ArrayList;
import java.util.Collection;

public class CollectionInterface {
    public static void main(String[] args) {
        Collection<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);

        System.out.println(nums);
    }
}
