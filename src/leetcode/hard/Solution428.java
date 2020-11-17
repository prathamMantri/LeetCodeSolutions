package leetcode.hard;

import model.NTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution428 {
    // Encodes a tree to a single string.
    int pos = 0;

    public String serialize(NTreeNode root) {
        StringBuilder data = new StringBuilder();
        if (root == null) {
            return data.toString();
        }
        data = serialize(root, new StringBuilder());
        return data.toString();
    }

    private StringBuilder serialize(NTreeNode node, StringBuilder data) {
        StringBuilder currLevel = new StringBuilder();
        if (node.children != null)
            for (int i = 0; i < node.children.size(); i++)
                currLevel = currLevel.append(serialize(node.children.get(i), new StringBuilder()));
        return data.append(node.val).append(",")
                .append(node.children == null ? "0" : node.children.size())
                .append(",")
                .append(currLevel);
    }

    // Decodes your encoded data to tree.
    public NTreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] nodes = data.split(",");
        return deserialize(new NTreeNode(Integer.parseInt(nodes[0])), nodes, 1);
    }

    //  0   1   2   3   4   5   6   7   8   9   10  11
    //  1   3   3   2   5   0   6   0   2   0   4   0
    public NTreeNode deserialize(NTreeNode node, String[] nodes, int childIndex) {
        List<NTreeNode> children = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(nodes[childIndex]); i++) {
            pos = pos + 2;
            children.add(deserialize(new NTreeNode(Integer.parseInt(nodes[pos])), nodes, pos + 1));
        }
        node.children = children;
        return node;
    }
}
