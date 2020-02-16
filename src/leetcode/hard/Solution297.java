package leetcode.hard;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution297 {

    // Encodes a tree to a single string.

   /* public String serialize(TreeNode root) {
        List<String> serialized = new ArrayList<>();
        serialize(root, serialized);
        System.out.println(serialized.toString());
        return serialized.toString();
    }

    private void serialize(TreeNode root, List<String> serialized){
        if(root == null){
            serialized.add("null");
            return;
        }
        serialized.add(String.valueOf(root.data));
        serialize(root.left, serialized);
        serialize(root.right, serialized);

    }*/

    public static void main(String[] args) {
        Solution297 sol = new Solution297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(sol.deserialize(sol.serialize(root)));
    }

    public String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += root.data + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = rserialize(root, "");
        System.out.println(result);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replace("[", "").replace("]", "").trim();
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return deserialize(dataList);
    }

    private TreeNode deserialize(List<String> dataList) {
        if (!dataList.isEmpty()) {
            if (dataList.get(0).equals("null")) {
                dataList.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
            dataList.remove(0);
            root.left = deserialize(dataList);
            root.right = deserialize(dataList);

            return root;
        }
        return null;
    }


}
