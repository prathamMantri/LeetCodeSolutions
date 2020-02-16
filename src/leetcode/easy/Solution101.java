package leetcode.easy;

import model.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        return compareTrees(left, right);

    }

    public boolean compareTrees(TreeNode left, TreeNode right){

        if(left==null && right== null)
            return true;
        if(left==null || right==null)
            return false;
        return left.data==right.data && compareTrees(left.left, right.right) && compareTrees(left.right, right.left);

    }

}
