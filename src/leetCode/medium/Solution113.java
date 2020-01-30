package leetCode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> pathSumList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPathNodes(root, pathSumList, path, sum);
        return pathSumList;
    }

    public boolean getPathNodes(TreeNode root, List<List<Integer>> pathSumList, List<Integer> path, int sum) {
        if (root == null) {
            return sum == 0;
        }

        return getPathNodes(root.left, pathSumList, path, sum - root.data) || getPathNodes(root.right, pathSumList, path, sum - root.data);

    }


}
