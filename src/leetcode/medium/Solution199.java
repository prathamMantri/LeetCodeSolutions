package leetcode.medium;

import model.TreeNode;

import java.util.*;

public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        int level = 0;
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new ArrayList<>(Arrays.asList(root.data));
        }
        Map<Integer, Integer> map = new HashMap<>();
        findVisible(map, root, level, res);
        return res;
    }

    void findVisible(Map<Integer, Integer> map, TreeNode node, int level, List<Integer> list) {

        if (!map.containsKey(level)) {
            map.put(level, node.data);
            list.add(node.data);
        }
        level++;
        if (node.right != null) {
            findVisible(map, node.right, level, list);
        }
        if (node.left != null) {
            findVisible(map, node.left, level, list);
        }
    }

}
