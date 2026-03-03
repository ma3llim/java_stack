import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SteamAPI {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 2, 8, 9, 10, 12, 74);
        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        Stream<Integer> s3 = s2.map(n -> n * 2);
        int result = s3.reduce(0, (c, e) -> c + e);
        System.out.println(result);

        List<Integer> numbers = Arrays.asList(4, 5, 7, 2, 8);
        int result2 = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(0, (c, e) -> c + e);
        System.out.println(result2);
    }
}