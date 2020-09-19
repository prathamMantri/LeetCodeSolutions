package interview_questions_facebook;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfVisibleNodesFromLeft {
    public static void main(String[] args) {
        NumberOfVisibleNodesFromLeft sol = new NumberOfVisibleNodesFromLeft();
        TreeNode root_1 = new TreeNode(8);
        root_1.left = new TreeNode(3);
        root_1.right = new TreeNode(10);
        //root_1.left.left = new TreeNode(1);
        //root_1.left.right = new TreeNode(6);
        root_1.right.right = new TreeNode(14);
        // root_1.left.right.left = new TreeNode(4);
        // root_1.left.right.right = new TreeNode(7);
        root_1.right.right.left = new TreeNode(13);
        System.out.println(sol.visibleNodes(root_1));
    }

    void findVisible(Map<Integer, Integer> map, TreeNode node, int level) {

        if (!map.containsKey(level)) {
            map.put(level, node.val);
        }
        level++;
        if (node.left != null) {
            findVisible(map, node.left, level);
        }
        if (node.right != null) {
            findVisible(map, node.right, level);
        }
    }

    int visibleNodes(TreeNode root) {
        // Write your code here
        int level = 0;
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();

        findVisible(map, root, level);

        System.out.println(map.toString());
        return map.size();
    }


}
