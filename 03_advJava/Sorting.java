import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(3);
        nums.add(7);
        nums.add(9);

        Collections.sort(nums);

        System.out.println(nums);
    }
}
