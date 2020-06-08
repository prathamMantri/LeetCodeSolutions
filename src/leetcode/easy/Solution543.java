package leetcode.easy;

import model.TreeNode;

public class Solution543 {

    int res;

    public static void main(String[] args) {

        Solution543 sol = new Solution543();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(sol.diameterOfBinaryTree(root));

    }

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        findDiameter(root);
        return res - 1;

    }

    int findDiameter(TreeNode node) {
        if (node == null) return 0;
        int L = findDiameter(node.left);
        int R = findDiameter(node.right);
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }


}
