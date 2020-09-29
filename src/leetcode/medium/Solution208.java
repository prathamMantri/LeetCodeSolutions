package leetcode.medium;

import model.TrieNode;

public class Solution208 {

    private final TrieNode root;


    /**
     * Initialize your data structure here.
     */
    public Solution208() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        Solution208 sol = new Solution208();
        sol.insert("apple");
        System.out.println(sol.search("apple"));
        System.out.println(sol.search("app"));
        System.out.println(sol.startsWith("app"));
        sol.insert("app");
        System.out.println(sol.search("app"));
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.putNode(currentChar, new TrieNode());
            }
            node = node.getNode(currentChar);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.getNode(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }


}
