package Collections.ArrayListLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccessComparison {
    public static void main(String[] args){
        int size = 1_000_000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();
        arrayList.get(900_000);

        long end = System.nanoTime();
        System.out.println("ArrayList Access: " + (end - start) + " ns");

        start = System.nanoTime();

        linkedList.get(900_000);

        end = System.nanoTime();
        System.out.println("LinkedList Access: " + (end - start) + " ns");
    }
}
