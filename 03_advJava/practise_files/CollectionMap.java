package practise_files;

import java.util.HashMap;
import java.util.Map;

public class CollectionMap {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();

        students.put("Navin", 56);
        students.put("Harsh", 23);
        students.put("Sushil", 67);
        students.put("Kiran", 92);
        students.put("Sameer", 96);

        for (String key : students.keySet()) {
            System.out.println(key + ": " + students.get(key));
        }
    }
}