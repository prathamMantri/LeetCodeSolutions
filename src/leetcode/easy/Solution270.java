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
        double diff = Math.abs(root.data - target);
        return findClosestDist(root, target, diff, root.data);
    }

    int findClosestDist(TreeNode node, double target, double diff, int res) {
        if (node != null) {
            double currDiff = Math.abs(node.data - target);
            res = currDiff < diff ? node.data : res;
            diff = Math.min(diff, Math.abs(node.data - target));
            if (target < node.data) {
                return findClosestDist(node.left, target, diff, res);
            } else {
                return findClosestDist(node.right, target, diff, res);
            }
        } else {
            return res;
        }
    }

}
