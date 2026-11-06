package problems;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleII {
    public static ListNode detectCycleBruteForce(ListNode head) {
        ListNode current = head;
        Set<ListNode> set = new HashSet<>();

        while (current != null) {
            if (set.contains(current)) {
                return current;
            }

            set.add(current);
            current = current.next;
        }

        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        head.next.next.next = head.next;
        System.out.println(detectCycle(head));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head.next = head;
        System.out.println(detectCycle(head2));

        ListNode head3 = new ListNode(1);
        System.out.println(detectCycle(head3));
    }
}
