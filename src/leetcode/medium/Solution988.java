package leetcode.medium;

import model.TreeNode;

import java.util.Set;
import java.util.TreeSet;

public class Solution988 {

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return (char) (root.val + 'a') + "";
        }
        String s = "";
        Set<String> paths = new TreeSet<>();
        findPath(paths, root, s);
        return paths.iterator().next();
    }

    void findPath(Set<String> paths, TreeNode node, String s) {

        char c = (char) (node.val + 'a');
        s = c + s;
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
