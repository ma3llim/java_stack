package Stream;

import java.lang.classfile.attribute.PermittedSubclassesAttribute;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args){
        // filter
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
        nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        // map
        List<String> names = List.of("sameer", "rahul");
        names.stream().map(String::toUpperCase).forEach(System.out::println);

        // reduce
        int sum = List.of(1,2,3,4,5).stream().reduce(0, (a,b)-> a+b);
        System.out.println(sum);

        // collect
        List<String> result = names.stream().filter(name-> name.length() > 4).collect(Collectors.toList());
        System.out.println(result);

        // forEach
        names.forEach(System.out::println);
    }
}
