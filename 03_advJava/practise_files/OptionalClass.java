package practise_files;

import java.util.Arrays;
import java.util.List;

public class OptionalClass {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Navin", "Lakshmi", "John", "kirshor", "Afreen", "pagli");

        String name = names.stream()
                .filter(str -> str.contains("x")).findFirst().orElse("Not Found");

        System.out.println(name);
    }
}
