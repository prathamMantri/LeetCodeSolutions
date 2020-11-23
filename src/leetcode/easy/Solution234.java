package leetcode.easy;

import model.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == null)
            return true;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverse = slow.next;
        reverse = reverse(reverse);
        fast = head;

        while (reverse != null) {
            if (fast.val != reverse.val)
                return false;
            fast = fast.next;
            reverse = reverse.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
       /* if(node == null || node.next==null){
            return node;
        }
        ListNode start = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return start;
        */
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
