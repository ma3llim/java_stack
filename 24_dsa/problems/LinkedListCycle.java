package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * ListNode
 */
class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListCycle {
    public static boolean hasCycleBruteForce(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (set.contains(current)) {
                return true;
            }
            set.add(current);
        }

        return false;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);

        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        head.next.next.next = head.next;

        System.out.println(hasCycle(head));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next = head.next;

        System.out.println(hasCycle(head2));
    }
}
