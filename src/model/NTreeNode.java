package model;

import java.util.List;

public class NTreeNode {
    public int val;
    public String lastname;
    public String firstName;
    public List<NTreeNode> children;

    public NTreeNode() {
    }

    public NTreeNode(int _val) {
        val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
