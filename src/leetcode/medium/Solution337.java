package leetcode.medium;

import model.TreeNode;

public class Solution337 {

     /* public int rob(TreeNode root) {
        if(root == null)
            return 0;
        return rob(root, new HashMap<TreeNode, Integer>());

    }
    private int rob(TreeNode node, Map<TreeNode, Integer> map){
        if(node == null)
            return 0;
        int val = 0;
        int left =0 , right =0;
        if(map.containsKey(node))
            return map.get(node);
       if(node.left!=null)
           val = val + rob(node.left.left, map) + rob(node.left.right, map);
        if(node.right!=null)
            val = val + rob(node.right.left, map) + rob(node.right.right, map);
        val = Math.max(val + node.val, rob(node.left, map) + rob(node.right, map));
        map.put(node, val);
        return val;
    }
    */

    public int rob(TreeNode root) {

        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode node) {

        if (node == null) return new int[2];

        int[] left = robSub(node.left);
        int[] right = robSub(node.right);

        int[] res = new int[2];

        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);


        return res;
    }


}
