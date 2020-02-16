package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution819 {
    public static void main(String[] args) {
        Solution819 solution = new Solution819();
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};


        solution.mostCommonWord(paragraph, banned);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordCount = new HashMap<>();
        HashSet<String> bannedWords = new HashSet<>();
        String[] words = paragraph.split(" ");
        for (String word : banned) {
            bannedWords.add(word);
        }
        for (String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int count = 0;
        String result = "";
        for (String key : wordCount.keySet()) {
            if (count < wordCount.get(key) && !key.equals("")) {
                result = key;
                count = wordCount.get(key);
            }
        }
        return result;
    }


}
