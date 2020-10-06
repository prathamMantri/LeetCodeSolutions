package leetcode.medium;

import model.TreeNode;

import java.util.*;

public class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {

        List<TreeNode> result;
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Stack<TreeNode> evenStack = new Stack<>();
        Stack<TreeNode> oddStack = new Stack<>();
        if (root == null) {
            return false;
        }
        int level = 0;
        evenStack.push(root);

        while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
            while (!evenStack.isEmpty()) {
                TreeNode node = evenStack.pop();
                if (map.get(level) == null) {
                    result = new ArrayList<>();
                } else {
                    result = map.get(level);
                }
                result.add(node);
                map.put(level, result);
                if (node.left != null)
                    oddStack.push(node.left);
                if (node.right != null)
                    oddStack.push(node.right);
            }
            level++;
            while (!oddStack.isEmpty()) {
                TreeNode node = oddStack.pop();
                if (map.get(level) == null) {
                    result = new ArrayList<>();
                } else {
                    result = map.get(level);
                }
                result.add(node);
                map.put(level, result);
                if (node.right != null)
                    evenStack.push(node.right);
                if (node.left != null)
                    evenStack.push(node.left);

            }
            level++;
        }
        for (Integer key : map.keySet()) {
            List<TreeNode> list = map.get(key);
            int val = -1;

            for (TreeNode node : list) {
                if (key % 2 == 0 && node.val % 2 == 0) {
                    return false;
                } else if (key % 2 != 0 && node.val % 2 != 0) {
                    return false;
                } else if (node.val > val) {
                    val = node.val;
                } else
                    return false;
            }
        }
        return true;

    }


}
