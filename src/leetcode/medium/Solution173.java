package leetcode.medium;

import model.TreeNode;

import java.util.Stack;

public class Solution173 {
    Stack<TreeNode> st;
    TreeNode nextNode;

    public Solution173(TreeNode root) {

        st = new Stack<>();
        nextNode = root;
        pushInStack(nextNode);

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        Solution173 sol = new Solution173(root);


        System.out.println(sol.next());
        System.out.println(sol.next());
        System.out.println(sol.hasNext());
        System.out.println(sol.next());
        System.out.println(sol.hasNext());
        System.out.println(sol.next());
        System.out.println(sol.hasNext());
        System.out.println(sol.next());
        System.out.println(sol.hasNext());

    }

    /**
     * @return the next smallest number
     */
    public int next() {
        nextNode = st.pop();
        int res = nextNode.data;
        if (nextNode.right != null) {
            pushInStack(nextNode.right);
        }
        return res;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushInStack(TreeNode nextNode) {
        while (nextNode != null) {
            st.push(nextNode);
            nextNode = nextNode.left;
        }
    }


}
