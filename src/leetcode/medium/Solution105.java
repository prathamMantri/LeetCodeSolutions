package leetcode.medium;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, preorder.length - 1, 0, inorder.length - 1, preorder, inorder, map);
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        int leftSide = index - inStart;

        root.left = buildTree(preStart + 1, preStart + leftSide, inStart, index - 1, preorder, inorder, map);
        root.right = buildTree(preStart + leftSide + 1, preEnd, index + 1, inEnd, preorder, inorder, map);

        return root;
    }
}
