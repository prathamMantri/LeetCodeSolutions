package leetcode.medium;

import javafx.util.Pair;
import model.TreeNode;

import java.util.LinkedList;

public class Solution662 {
   /* public int widthOfBinaryTree(TreeNode root) {
        List<Integer> levelLMN = new ArrayList<>(); // levelLMN level left most node
        return dfs(root, 1, 0, levelLMN);
    }

    private int dfs(TreeNode root, int id, int level, List<Integer> levelLMN) {
        if (root == null) return 0;
        System.out.println("At level " + level);
        if (level == levelLMN.size()) {
            System.out.println("New Id being added in list " + id);
            levelLMN.add(id); // add left most node
        }
        System.out.println((id + 1 - levelLMN.get(level)) + " is current width");

        System.out.println("-------------maxWidth calculated as " + id + " + 1 - levelLMN.get(level)  " + levelLMN.get(level) + " = " + (id + 1 - levelLMN.get(level)) + "---------------");
        System.out.println("---------------------------------At current node " + root.val + "---------------------------------------------");
        System.out.println("---------------------------------" + levelLMN.toString() + "---------------------------------------------");

        return Math.max(id + 1 - levelLMN.get(level),
                Math.max(dfs(root.left, id * 2, level + 1, levelLMN),
                        dfs(root.right, id * 2 + 1, level + 1, levelLMN)));
    }*/


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        // queue of elements [(node, col_index)]
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int maxWidth = 0;

        queue.addLast(new Pair<>(root, 0));
        while (queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();

            // iterate through the current level
            int currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;
            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.getKey();
                if (node.left != null)
                    queue.addLast(new Pair<>(node.left, 2 * elem.getValue()));
                if (node.right != null)
                    queue.addLast(new Pair<>(node.right, 2 * elem.getValue() + 1));
            }

            // calculate the length of the current level,
            //   by comparing the first and last col_index.
            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }

        return maxWidth;
    }

}
