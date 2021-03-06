package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        String s = "";
        List<String> paths = new ArrayList<>();
        int sum = 0;
        findPath(paths, root, s);
        for (String vals : paths) {
            sum = sum + Integer.parseInt(vals);
        }
        return sum;
    }

    void findPath(List<String> paths, TreeNode node, String s) {

        s = s + node.val;
        if (node.left == null && node.right == null) {
            paths.add(s);
            return;
        }
        if (node.left != null) {
            findPath(paths, node.left, s);
        }
        if (node.right != null) {
            findPath(paths, node.right, s);
        }
    }

}
