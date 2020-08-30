package leetcode.medium;

import model.TreeNode;

import java.util.*;

public class Solution987 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<Integer>> treeMap = new TreeMap<>();
        helper(root, treeMap, 0);
        for (Integer index : treeMap.keySet()) {
            result.add(new ArrayList<>(treeMap.get(index)));
        }
        return result;
    }


    void helper(TreeNode node, Map<Integer, Set<Integer>> treeMap, int index) {
        if (node == null) {
            return;
        }
        Set<Integer> temp = new TreeSet<>();
        if (treeMap.containsKey(index)) {
            temp = treeMap.get(index);
        }
        temp.add(node.val);
        treeMap.put(index, temp);
        helper(node.left, treeMap, index - 1);
        helper(node.right, treeMap, index + 1);


    }

}
