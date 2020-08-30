package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        Solution102 sol = new Solution102();
        System.out.println(sol.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();

        queue.add(root);
        queue.add(new TreeNode(-1));

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.val == -1) {
                if (!queue.isEmpty()) {
                    queue.add(new TreeNode(-1));
                }
                results.add(new ArrayList<>(res));
                res.clear();
            } else {
                res.add(currentNode.val);
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
        }
        return results;
    }


}
