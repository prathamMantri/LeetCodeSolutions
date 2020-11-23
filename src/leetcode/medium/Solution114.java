package leetcode.medium;

import model.TreeNode;

public class Solution114 {
    public void flatten(TreeNode root) {
        //base case
        if (root == null)
            return;
        //call helper function by passing current node and its parent node, initially parent node set to null
        flattenTree(root, null);
    }


    private TreeNode flattenTree(TreeNode node, TreeNode parentNode) {
        //base case, if current node is null, just return parentnode.
        if (node == null) {
            return parentNode;
        }
        // set parent node by recusrively calling helper method and passing current node as right child.
        parentNode = flattenTree(node.right, parentNode);
        // once recusrion ends, meaning we are at the end of the right level, parent node extreme right  child
        // now set parentnode by recursively calling helper method by passing current node as left child
        parentNode = flattenTree(node.left, parentNode);
        // now once recursion ends, meaning we are at the end of leff level, parent node extreme left child
        // just make current nodes right as parentnode which is actually extrem left
        node.right = parentNode;
        // make, node. left to null, as we do not need it now
        node.left = null;
        // just return node.
        return node;

        /*
        if(root==null) return ;
        flatten(root.right, parentNode);
        if (root.right == null) root.right = parentNode;
        flatten(root.left, root.right);
        if (root.left != null) root.right = root.left;
        root.left = null;
        */
    }
}
