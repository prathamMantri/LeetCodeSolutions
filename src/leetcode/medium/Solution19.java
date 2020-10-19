package leetcode.medium;

import model.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode current_n = dummy;

        int pos = 1;

        if (head.next == null && n == 1)
            return null;

        while (pos <= n + 1) {
            current_n = current_n.next;
            pos++;
        }
        while (current_n != null) {
            current_n = current_n.next;
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }

}
