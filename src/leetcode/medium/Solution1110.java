package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;

        if (to_delete.length == 0) {
            result.add(root);
            return result;
        }

        Set<Integer> delete = new HashSet<>();
        for (int i : to_delete) {
            delete.add(i);
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        if (delete.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
        } else {
            result.add(root);
        }

        helper(leftNode, delete, result, root, true);
        helper(rightNode, delete, result, root, false);
        return result;
    }

    void helper(TreeNode node, Set<Integer> delete, List<TreeNode> result, TreeNode parent, boolean isLeft) {

        if (node == null) {
            return;
        }

        if (delete.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
                helper(node.right, delete, result, node, false);
            }

            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }

            result.remove(node);

        }

        helper(node.left, delete, result, node, true);
        helper(node.right, delete, result, node, false);
    }
}
