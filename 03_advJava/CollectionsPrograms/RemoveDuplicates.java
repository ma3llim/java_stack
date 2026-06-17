package CollectionsPrograms;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "cherry", "banana", "date"));

        Set<String> set = new HashSet<>(list);

        List<String> lists = new ArrayList<>(set);

        System.out.println(lists);
    }
}
