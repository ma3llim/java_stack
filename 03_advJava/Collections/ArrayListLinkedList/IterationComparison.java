package Collections.ArrayListLinkedList;

import java.util.ArrayList;
import java.util.List;

public class IterationComparison {
    public static void main(String[] args){
        int size = 1_000_000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new ArrayList<>();

        for(int i=0; i < size; i++){
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();
        long sum = 0;

        for(Integer i : arrayList){
            sum+=1;
        }

        long end = System.nanoTime();
        System.out.println("ArrayList Iteration: " + (end - start) + " ns");

        start = System.nanoTime();
        sum = 0;
        for (Integer i : linkedList) {
            sum += i;
        }
        end = System.nanoTime();
        System.out.println("LinkedList Iteration: " + (end - start) + " ns");
    }
}
