package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution865 {
    public static void main(String[] args) {


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Solution865 sol = new Solution865();
        sol.subtreeWithAllDeepest(root);

    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        if ((root.left == null && root.right == null) || root == null) {
            return root;
        }
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        int level = 0;
        map.put(level, null);
        level = fillMap(map, level, root);

        return map.get(level - 1).get(0);

    }

    int fillMap(Map<Integer, List<TreeNode>> map, int level, TreeNode node) {

        if (node.left == null && node.right == null) {
            return level;
        }

        List<TreeNode> parentNodes;

        if (map.containsKey(level)) {
            parentNodes = map.get(level);
            if (parentNodes != null)
                parentNodes.add(node);
        } else {
            parentNodes = new ArrayList<>();
            parentNodes.add(node);
            map.put(level, parentNodes);
        }

        if (node.left != null) {
            level = Math.max(level, fillMap(map, level, node.left));
        }
        if (node.right != null) {
            level = Math.max(level, fillMap(map, level, node.right));
        }
        return level;
    }

}
