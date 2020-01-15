package leetCode.medium;


import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        Solution366 solution366 = new Solution366();
        solution366.findLeaves(root);
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leavesList = new ArrayList<>();
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = collectLeaves(root, leaves);
            leavesList.add(leaves);
        }
        System.out.println(leavesList.toString());
        return leavesList;
    }

    public TreeNode collectLeaves(TreeNode root, List<Integer> leaves) {

        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.data);
            root = null;
        } else {
            root.left = collectLeaves(root.left, leaves);
            root.right = collectLeaves(root.right, leaves);
        }
        return root;
    }


}
