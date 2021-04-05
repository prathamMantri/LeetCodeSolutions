package leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution140 {


    // TO save a word break from particular string

    Map<String, LinkedList<String>> map = new HashMap<>();

    public List<String> wordBreak2(String s, List<String> wordDict) {

        if (map.containsKey(s)) {
            return map.get(s);
        }

        // Define a result to be returned.
        LinkedList<String> res = new LinkedList<>();

        if (s.length() == 0) {
            res.add("");
            return res;
        }

        // Lets go through every word in  the dictionary and find out if current sentence starts with that word
        for (String word : wordDict) {

            if (s.startsWith(word)) {
                // if it starts with that word, then break the word from that sentense and again call the same method to find out remaining sentence starts with a word in dictionary.
                // Also, save the result in a List, where list will contains the spaced word.
                List<String> subList = wordBreak2(s.substring(word.length()), wordDict);
                // with each recursive call, subList will be filled with current matching word and hence res can be updated with current word and formed string from the subList
                for (String sub : subList) {
                    // for the last word, subList will contain empty string.
                    res.add(word + (sub.length() > 0 ? " " : "") + sub);
                }
            }
        }

        // save remaining string in the map with the res List, so that if same String found again, one can directly return the already calculated list for that string.
        map.put(s, res);

        return res;

    }
}
