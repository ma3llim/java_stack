package Collections.ArrayListLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertComparison {
    public static void main(String[] args){
        int size = 100_000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();
        arrayList.add(0, -1);

        long end = System.nanoTime();
        System.out.println("ArrayList Insert Access: " + (end - start) + " ns");

        start = System.nanoTime();

        linkedList.add(0,-1);

        end = System.nanoTime();
        System.out.println("LinkedList Insert Access: " + (end - start) + " ns");
    }
}
