package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution113 {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution113 solution113 = new Solution113();
        solution113.pathSum(root, 22);

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        getPath(paths, new ArrayList<Integer>(), root, sum);
        return paths;
    }

    public void getPath(List<List<Integer>> paths, List<Integer> path, TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && root.val == sum) {
            path.add(root.val);
            paths.add(new ArrayList<>(path));
        }
        path.add(root.val);
        getPath(paths, new ArrayList<Integer>(path), root.left, sum - root.val);
        getPath(paths, new ArrayList<Integer>(path), root.right, sum - root.val);
    }

}
