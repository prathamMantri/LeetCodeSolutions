package companies.interview_questions_microsoft.codility;

import model.TreeNode;

public class Question1 {
    int answer = 1;

    public int solution(TreeNode T) {
        if (T == null)
            return -1;
        if (T.left == null && T.right == null)
            return T.val;
        TreeNode node = T;
        int max = node.val;
        if (node.left != null)
            helper(node.left, max);
        if (node.right != null)
            helper(node.right, max);
        return answer;
    }

    private void helper(TreeNode node, int max) {
        int current = node.val;
        if (current >= max) {
            answer++;
            max = current;
        }
        if (node.left != null)
            helper(node.left, max);
        if (node.right != null)
            helper(node.right, max);
    }

}
