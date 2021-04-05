package leetcode.hard;

import model.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution472 {

    TrieNode root = new TrieNode();


    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        //sort the array in asc order of word length, since longer words are formed by shorter words.
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        List<String> result = new ArrayList<>();

        //list of shorter words
        HashSet<String> preWords = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            //Word Break-I problem.
            if (wordBreak(words[i], preWords)) result.add(words[i]);
            preWords.add(words[i]);
        }
        return result;
    }

    private boolean wordBreak(String s, HashSet<String> preWords) {
        if (preWords.isEmpty()) return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && preWords.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public List<String> findAllConcatenatedWordsInADictUsingTrie(String[] words) {
        if (null == words || words.length == 0) {
            return new ArrayList<>();
        }
        root = new TrieNode();
        buildTrie(words);

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (isConcatenatedWord(word, 0, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    void buildTrie(String[] words) {
        TrieNode node;
        for (String word : words) {
            node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.putNode(ch, new TrieNode());
                }
                node = node.getNode(ch);
            }
            node.setEnd();
        }
    }

    boolean isConcatenatedWord(String word, int index, int count) {
        if (index == word.length()) {
            return count >= 2;
        }
        TrieNode node = root;
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch))
                return false;

            node = node.getNode(ch);
            if (node.isEnd() && isConcatenatedWord(word, i + 1, count + 1))
                return true;
        }
        return false;
    }
}
