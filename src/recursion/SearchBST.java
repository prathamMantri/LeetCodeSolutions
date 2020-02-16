package recursion;

import model.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data == val) {
            return root;
        }
        return searchBST(root.data > val ? root.left : root.right, val);
    }
}
