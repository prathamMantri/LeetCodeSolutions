package model;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<Character, TrieNode> nodes;
    Boolean isEnd;

    public TrieNode() {
        nodes = new HashMap<>();
        isEnd = false;
    }

    public Boolean containsKey(char ch) {
        return nodes.get(ch) != null;
    }

    public TrieNode getNode(char ch) {
        return nodes.get(ch);
    }

    public void putNode(char ch, TrieNode trieNode) {
        nodes.put(ch, trieNode);
    }

    public Map<Character, TrieNode> getNodes() {
        return nodes;
    }

    public void setNodes(Map<Character, TrieNode> nodes) {
        this.nodes = nodes;
    }

    public Boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
