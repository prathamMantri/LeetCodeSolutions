package leetcode.easy;

import model.TreeNode;

public class Solution270 {

    public static void main(String[] args) {
        Solution270 sol = new Solution270();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(sol.closestValue(root, 3.428571));


    }

    public int closestValue(TreeNode root, double target) {
        double diff = Math.abs(root.val - target);
        return findClosestDist(root, target, diff, root.val);
    }

    int findClosestDist(TreeNode node, double target, double diff, int res) {
        if (node != null) {
            double currDiff = Math.abs(node.val - target);
            res = currDiff < diff ? node.val : res;
            diff = Math.min(diff, Math.abs(node.val - target));
            if (target < node.val) {
                return findClosestDist(node.left, target, diff, res);
            } else {
                return findClosestDist(node.right, target, diff, res);
            }
        } else {
            return res;
        }
    }

}
