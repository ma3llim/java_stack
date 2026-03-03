import java.util.Arrays;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Navin", "Harsh", "John");

        List<String> uNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(uNames);
    }
}