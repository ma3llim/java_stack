package Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ColllectorsMethods {
    public static void main(String[] args){
        List<String> names = List.of("Sameer", "Rahul", "Amit", "Irfan");

        // toList
        List<String> result = names.stream().filter(name -> name.length() > 4).collect(Collectors.toList());

        // toMap
        Map<String, Integer> resultMap = names.stream().collect(
                Collectors.toMap(name -> name, name -> name.length()
                )
        );

        // groupingBy
        Map<Integer, List<String>> resultGroupingBy = names.stream().collect(
                Collectors.groupingBy(String::length)
        );

        // joining
        String resultString = names.stream().collect(Collectors.joining(", "));
        System.out.println(resultString);
    }
}
