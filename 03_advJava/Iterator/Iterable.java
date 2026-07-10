package Iterator;

import java.util.Iterator;
import java.util.List;

public class Iterable {
    public static void main(String[] args) {
        List<String> names = List.of("Sam", "John", "Alex");
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
