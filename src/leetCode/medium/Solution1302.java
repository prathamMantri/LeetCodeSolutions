package leetCode.medium;

import model.TreeNode;

import java.util.HashMap;

/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * <p>
 * Constraints:
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */

public class Solution1302 {
    int level = 0;
    HashMap<Integer, Integer> levelMap = new HashMap<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        Solution1302 solution1302 = new Solution1302();
        System.out.println(solution1302.deepestLeavesSum(root));
    }
    private int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, level, levelMap, true);
        return levelMap.get(levelMap.size());
    }
    private void deepestLeavesSum(TreeNode root, int level, HashMap<Integer, Integer> levelMap, Boolean isLeft) {
        if (root == null) {
            if (!isLeft) {
                level--;
            }
            return;
        }
        level++;
        levelMap.put(level, null != levelMap.get(level) ? levelMap.get(level) + root.data : root.data);
        deepestLeavesSum(root.left, level, levelMap, true);
        deepestLeavesSum(root.right, level, levelMap, false);
    }
}
