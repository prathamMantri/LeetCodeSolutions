package leetcode.medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution314 {

    public static void main(String[] args) {

        Solution314 sol = new Solution314();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);

        System.out.println(sol.verticalOrder(root));


    }

    public List<List<Integer>> verticalOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();

        int index = 0;
        List<Integer> list = new ArrayList<>();
        list.add(root.data);
        map.put(index, list);

        verticalOrder(root.left, map, index + 1);
        verticalOrder(root.right, map, index - 1);

        int count = map.size();

        ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
        for (int i = keys.size() - 1; i >= 0; i--) {
            res.add(map.get(keys.get(i)));
        }
        return res;
    }

    void verticalOrder(TreeNode node, Map<Integer, List<Integer>> map, int index) {

        if (node == null)
            return;

        List<Integer> list;

        if (map.containsKey(index)) {
            list = map.get(index);
            if (index < 0) {
                list.add(list.size() - 1, node.data);
            } else {
                list.add(list.size(), node.data);
            }
        } else {
            list = new ArrayList<>();
            list.add(0, node.data);
            map.put(index, list);
        }
        verticalOrder(node.left, map, index + 1);
        verticalOrder(node.right, map, index - 1);

    }


}
