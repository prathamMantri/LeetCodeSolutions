package leetcode.easy;

import model.ListNode;

public class Solution237 {
    public void deleteNode(ListNode node) {
        if (node == null)
            return;
        ListNode current = node;
        current.val = node.next.val;
        current.next = node.next.next;
        return;
    }
}
