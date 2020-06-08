package leetcode.easy;

import model.TreeNode;

public class Solution226 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        Solution226 sol = new Solution226();
        sol.invertTree(root);


    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            invertTree(root.left);
            invertTree(root.right);
        }
        invertLeaf(root);
        return root;
    }

    void invertLeaf(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
