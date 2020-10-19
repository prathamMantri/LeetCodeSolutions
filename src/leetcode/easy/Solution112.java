package leetcode.easy;

import model.TreeNode;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if ((root.left == null) && (root.right == null))
            return sum - root.val == 0;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    private boolean hasPath(TreeNode node, int sum) {
        if (node == null) return false;
        int val = node.val;
        if (node.val == sum) return true;
        return hasPath(node.left, sum - val) || hasPath(node.right, sum - val);
    }


}
