package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import blocks.ListNode;

public class MergekSortedLists {
    public static ListNode mergeKListsBruteForce(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        List<Integer> intList = new ArrayList<>();

        for (ListNode listNode : lists) {
            ListNode current = listNode;
            while (current != null) {
                intList.add(current.val);
                current = current.next;
            }
        }

        Collections.sort(intList);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : intList) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();

            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] lists1 = { l1, l2, l3 };
        System.out.println(mergeKLists(lists1));

        ListNode[] lists2 = {};
        System.out.println(mergeKLists(lists2));

        ListNode[] lists3 = { null };
        System.out.println(mergeKLists(lists3));
    }
}
