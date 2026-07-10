package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterable {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Sam", "John", "Alex"));
        Iterator<String> iterator = names.iterator();

        // while (iterator.hasNext()) {
        // System.out.println(iterator.next());
        // }
        // for (String name : names) {
        // names.remove(name);
        // }
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
}
