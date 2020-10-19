package leetcode.medium;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        getLevelSum(root, map, 0);

        if (map.size() == 1) {
            return root.val;
        }

        int prevMax = map.get(0);
        int currMax = Math.max(map.get(0), map.get(1));

        int temp = 0;

        for (int i = 2; i < map.size(); i++) {
            temp = currMax;
            currMax = Math.max(prevMax + map.get(i), currMax);
            prevMax = temp;
        }

        return currMax;

    }

    private void getLevelSum(TreeNode node, Map<Integer, Integer> map, int level) {
        if (node == null) {
            return;
        }
        map.put(level, map.getOrDefault(level, 0) + node.val);
        getLevelSum(node.left, map, level + 1);
        getLevelSum(node.right, map, level + 1);
    }
}
