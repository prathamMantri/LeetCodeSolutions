package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
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
    }
}
