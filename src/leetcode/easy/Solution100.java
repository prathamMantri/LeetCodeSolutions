package leetcode.easy;


import model.TreeNode;

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {


        return p == null && q == null || (p != null && q != null && (p.val == q.val && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))));


/*
        if(p == null && q== null ){
            return true;
        }else{
            if((p==null || q==null)){
                return false;
            }else if(p.data == q.data){
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }else{
                return false;
            }
        }
*/
    }
}
