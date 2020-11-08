package leetcode.medium;

import model.ListNode;
import model.TreeNode;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head);
    }

    TreeNode helper(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode mid = slowPointer;
        while (fastPointer != null && fastPointer.next != null) {
            mid = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        TreeNode root = new TreeNode(slowPointer.val);
        mid.next = null;
        root.left = helper(head);
        root.right = helper(slowPointer.next);
        return root;
    }
}
