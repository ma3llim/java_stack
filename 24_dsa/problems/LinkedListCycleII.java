package problems;

import java.util.HashSet;
import java.util.Set;
import blocks.ListNode;

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
        // Test Case 1: Cycle starts at node 2
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        head.next.next.next.next = head.next;

        ListNode result1 = detectCycle(head);
        System.out.println(result1 != null ? result1.val : null);

        // Test Case 2: Cycle starts at node 1
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;

        ListNode result2 = detectCycle(head2);
        System.out.println(result2 != null ? result2.val : null);

        // Test Case 3: No cycle
        ListNode head3 = new ListNode(1);

        ListNode result3 = detectCycle(head3);
        System.out.println(result3 != null ? result3.val : null);
    }
}
