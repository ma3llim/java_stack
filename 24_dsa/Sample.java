import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<List<String>> data = List.of(
                List.of("a", "b"),
                List.of("c"),
                List.of("d", "e", "f"));

        System.out.println(data.stream().map(t -> t.stream().toList()).toList().toString());
        System.out.println("------------------");
        System.out.println(data.stream().flatMap(List::stream).toList().toString());
    }
}