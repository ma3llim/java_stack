package problems;

import blocks.ListNode;

public class MiddleOfTheLinkedList {
    public static ListNode middleNodeBruteForce(ListNode head) {
        int counter = 0;
        ListNode current = head;

        while (current != null) {
            counter++;
            current = current.next;
        }

        int middleLength = counter / 2;
        ListNode middleListNode = head;

        while (middleLength > 0) {
            middleListNode = middleListNode.next;
            middleLength--;
        }

        return middleListNode;
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        System.out.println(middleNode(head).toString());
        System.out.println(middleNode(head2).toString());
    }

}
