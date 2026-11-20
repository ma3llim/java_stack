package problems;

import blocks.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(reverseList(head1).toString());

        ListNode head2 = new ListNode(1, new ListNode(2, null));
        System.out.println(reverseList(head2).toString());
    }
}
