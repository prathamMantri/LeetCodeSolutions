package easy;

import model.TreeNode;

public class Solution104 {

  /*  Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

            3
            / \
            9  20
            /  \
            15   7
            return its depth = 3.*/


    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + max(left, right);
    }

    public int max(int i, int j){
        return i>j?i:j;
    }

}
