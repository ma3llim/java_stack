package CollectionsPrograms.StackQuence;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args){
        Queue queue = new LinkedList();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
