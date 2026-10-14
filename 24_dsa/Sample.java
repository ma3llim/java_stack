import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<String> users = new ArrayList<>(List.of("Sameer", "John", "Alex", "Max", "Shareef", "Fahad"));
        Iterator<String> iterator = users.iterator();

        while (iterator.hasNext()) {
            String userName = iterator.next();
            System.out.println(userName);
        }
    }
}