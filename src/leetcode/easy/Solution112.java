package leetcode.easy;

import model.TreeNode;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if ((root.left == null) && (root.right == null))
            return sum - root.data == 0;
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }
}
