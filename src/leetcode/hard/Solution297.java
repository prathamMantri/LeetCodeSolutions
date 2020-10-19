package leetcode.hard;

import model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution297 {

    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        assert s != null;
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

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

    // Encodes a tree to a single string.
    /*  public String serialize1(TreeNode root) {
        String result = serialize(root, "");
        System.out.println(result);
        return result;
    }

    public String serialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = serialize(root.left, str);
            str = serialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
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
*/

}
