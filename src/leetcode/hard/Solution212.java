package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution212 {
    ///Using backtracking, not optimised, but accepted
    public List<String> findWords(char[][] board, String[] words) {

        int index = 0;
        List<String> list = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(index) && findWord(i, j, board, word, 0)) {
                        list.add(word);
                    }
                }
            }
        }
        return list;
    }

    public boolean findWord(int i, int j, char[][] board, String word, int index) {

        if (index >= word.length() || i < 0 || i > board.length - 1 || j > board[0].length - 1 || j < 0 || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        boolean op = findWord(i + 1, j, board, word, index + 1) ||
                findWord(i - 1, j, board, word, index + 1) ||
                findWord(i, j + 1, board, word, index + 1) ||
                findWord(i, j - 1, board, word, index + 1);
        board[i][j] = temp;
        return op;
    }

    public List<String> findWordsUsingTrie(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character ch : word.toCharArray()) {
                if (node.containsKey(ch)) {
                    node = node.getNode(ch);
                } else {
                    node.putNode(ch, new TrieNode());
                    node = node.getNode(ch);
                }
            }
            node.setEnd();
            node.setWord(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.containsKey(board[i][j]))
                    findWordsUsingTrie(i, j, root, board, res);
            }
        }
        return res;
    }

    public void findWordsUsingTrie(int i, int j, TrieNode node, char[][] board, List<String> res) {
        if (node.word != null) {
            res.add(node.getWord());
            node.word = null;
        }
        if (i < 0 || i > board.length - 1 || j > board[0].length - 1 || j < 0 || !node.containsKey(board[i][j])) {
            return;
        }
        char temp = board[i][j];
        node = node.getNode(temp);
        board[i][j] = '*';
        findWordsUsingTrie(i + 1, j, node, board, res);
        findWordsUsingTrie(i - 1, j, node, board, res);
        findWordsUsingTrie(i, j + 1, node, board, res);
        findWordsUsingTrie(i, j - 1, node, board, res);
        board[i][j] = temp;
    }

    static class TrieNode {
        Map<Character, TrieNode> nodes;
        Boolean isEnd;
        String word;

        public TrieNode() {
            nodes = new HashMap<>();
            isEnd = false;
        }

        boolean containsKey(char ch) {
            return nodes.containsKey(ch);
        }

        TrieNode getNode(char ch) {
            return nodes.get(ch);
        }

        void putNode(char ch, TrieNode trieNode) {
            nodes.put(ch, trieNode);
        }

        Map<Character, TrieNode> getNodes() {
            return nodes;
        }

        boolean isEnd() {
            return isEnd;
        }

        void setEnd() {
            isEnd = true;
        }

        String getWord() {
            return word;
        }

        void setWord(String word) {
            this.word = word;
        }
    }
}
