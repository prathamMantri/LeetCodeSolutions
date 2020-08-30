package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution655 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(6);

        Solution655 sol = new Solution655();

        sol.printTree(root);


    }

    public List<List<String>> printTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        int height = getHeight(root);
        List<List<String>> results = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<String> result = new ArrayList<>();
            for (int j = 0; j < ((1 << height) - 1); j++) {
                result.add("");
            }
            results.add(result);
        }


        List<NodeLevel> tempRes = new ArrayList<>();

        Queue<NodeLevel> queue = new LinkedList<>();

        queue.add(new NodeLevel(root, 1, "middle"));
        queue.add(new NodeLevel(new TreeNode(-1), 0, ""));
        int level = 2;

        while (!queue.isEmpty()) {
            NodeLevel nodeLevel = queue.poll();
            tempRes.add(nodeLevel);
            if (nodeLevel.node.val == -1) {
                if (!queue.isEmpty()) {
                    queue.add(new NodeLevel(new TreeNode(-1), 0, ""));
                }
                level++;
            }
            if (nodeLevel.node.left != null) queue.add(new NodeLevel(nodeLevel.node.left, level, "left"));
            if (nodeLevel.node.right != null) queue.add(new NodeLevel(nodeLevel.node.right, level, "right"));
        }

        System.out.println(tempRes);
        System.out.println(results);


        return null;
    }


    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.right), getHeight(node.left));
        }
    }

    static class NodeLevel {

        TreeNode node;
        int level;
        String side;

        NodeLevel(TreeNode node, int level, String side) {
            this.level = level;
            this.node = node;
            this.side = side;
        }
    }


}
