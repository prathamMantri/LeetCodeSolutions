package model;

public class TrieNode {
    private final int size = 26;
    TrieNode[] links;
    Boolean isEnd;

    public TrieNode() {
        links = new TrieNode[size];
    }

    public Boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode trieNode) {
        links[ch - 'a'] = trieNode;
    }

    public Boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }
}
