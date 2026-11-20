package problems;

import blocks.ListNode;

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode t = head;
        ListNode before = null;
        int pos = 1;

        if (head == null || left == right) {
            return head;
        }

        while (t != null && pos < left) {
            before = t;
            t = t.next;
            pos++;
        }

        ListNode prev = null;
        ListNode curr = t;
        int times = right - left + 1;

        while (times > 0) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

            times--;
        }

        if (before != null) {
            before.next = prev;
        } else {
            head = prev;
        }

        t.next = curr;

        return head;
    }

    public static void main(String[] args) {
        System.out.println(reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5, null))))), 2, 4));
        System.out.println(reverseBetween(new ListNode(5), 1, 1));
    }
}
