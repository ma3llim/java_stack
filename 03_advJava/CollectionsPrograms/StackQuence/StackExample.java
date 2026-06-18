package CollectionsPrograms.StackQuence;

import java.util.ArrayList;
import java.util.Stack;

public class StackExample {
    public static void main(String[] args){
        Stack<Integer> integers = new Stack<>();
        integers.push(10);
        integers.push(20);
        integers.push(30);
        integers.push(50);

        System.out.println(integers.pop());
        System.out.println(integers.peek());
    }
}
