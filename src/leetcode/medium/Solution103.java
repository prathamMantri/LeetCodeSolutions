package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null)
            return lists;
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode node = s1.pop();
                list.add(node.val);
                if(node.left!=null) s2.add(node.left);
                if(node.right!=null) s2.add(node.right);
            }
            if(!list.isEmpty())
                lists.add(new ArrayList<>(list));
            list.clear();
            while(!s2.isEmpty()){
                TreeNode node = s2.pop();
                list.add(node.val);
                if(node.right!=null) s1.add(node.right);
                if(node.left!=null) s1.add(node.left);
            }
            if(!list.isEmpty())
                lists.add(new ArrayList<>(list));
            list.clear();
        }
        return lists;
    }
}
