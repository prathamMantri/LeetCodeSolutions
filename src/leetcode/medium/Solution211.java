package leetcode.medium;

import model.TrieNode;

public class Solution211 {
    public static class WordDictionary {

        Trie trie;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            trie = new Trie();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            trie.insert(word, 0);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return trie.search(word, 0);
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word, int index) {
            if (index == word.length()) {
                root.setEnd();
                return;
            }
            char ch = word.charAt(index);
            TrieNode node = root.getNode(ch);
            if (node == null) {
                node = new TrieNode();
                root.putNode(ch, node);
            }
            insert(word, index + 1);
        }

        public boolean search(String word, int index) {
            if (index == word.length()) {
                return root.isEnd();
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (char key : root.getNodes().keySet()) {
                    //TrieNode node = root.getNode(key);
                    return search(word, index + 1);
                }
                return false;
            } else {
                TrieNode node = root.getNode(c);
                if (node != null) {
                    return search(word, index + 1);
                } else {
                    return false;
                }
            }
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */



