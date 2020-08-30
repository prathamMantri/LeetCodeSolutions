package leetcode.medium;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution449 {

    TreeNode node;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        Solution449 solution = new Solution449();
        System.out.println(solution.deserialize(solution.serialize(root)).toString());
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder serialize = new StringBuilder();
        serialize(root, serialize);
        return serialize.toString();
    }

    public StringBuilder serialize(TreeNode root, StringBuilder serialize) {
        if (root == null) {
            return serialize.append("null ");
        }
        serialize.append(root.val);
        serialize.append(" ");
        serialize(root.left, serialize);
        serialize(root.right, serialize);
        return serialize;
    }

    // Decodes your encoded data to tree. USE of QUEUE HELPS - Code is copied
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] vals = data.split(" ");
        if (vals.length == 0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        q.add(root);
        TreeNode p;
        String val;
        for (int i = 1; i < vals.length; ) {
            p = q.poll();
            val = vals[i++];
            if (val.equals("null")) {
                p.left = null;
            } else {
                p.left = new TreeNode(Integer.valueOf(val));
                q.add(p.left);
            }
            if (i < vals.length) {
                val = vals[i++];
                if (val.equals("null")) {
                    p.right = null;
                } else {
                    p.right = new TreeNode(Integer.valueOf(val));
                    q.add(p.right);
                }
            }
        }
        return root;
    }

}
