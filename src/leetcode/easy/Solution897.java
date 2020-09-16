package leetcode.easy;

import model.TreeNode;

import java.util.Stack;

public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<Integer> st = new Stack<>();
        inOrder(st, root);
        TreeNode node = new TreeNode(st.pop());
        TreeNode curr = node;
        while (!st.isEmpty()) {
            curr.right = new TreeNode(st.pop());
            curr = curr.right;
        }
        return node;
    }

    void inOrder(Stack<Integer> st, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(st, node.right);
        st.push(node.val);
        inOrder(st, node.left);
    }

}
