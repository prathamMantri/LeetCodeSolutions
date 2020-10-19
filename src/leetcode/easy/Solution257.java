package leetcode.easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }

    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.val + "->", answer);
    }


    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        helper(result, "", root);
        return result;
    }

    void helper(List<String> result, String s, TreeNode node) {
        if (node != null) {
            s = s + node.val;
            if (node.left == null && node.right == null) {
                result.add(s);
            } else {
                s = s + "->";
                helper(result, s, node.left);
                helper(result, s, node.right);
            }
        }
    }


}
