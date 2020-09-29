package leetcode.easy;

import model.TreeNode;

public class Solution700 {
    /*public TreeNode searchBST(TreeNode root, int val) {

        if(root == null ){
            return null;
        }
        if(root.val == val ){
            return root;
        }
        TreeNode node = root;
        if(node.val > val)
            return searchBST(node.left, val);
        else
            return searchBST(node.right, val);

    }*/

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;

        while (node != null) {
            if (node.val == val) {
                return node;
            }
            if (node.val < val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;

    }


}
