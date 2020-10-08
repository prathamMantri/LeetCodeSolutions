package leetcode.medium;

import java.util.*;

public class Solution1048 {
    public int longestStrChainDP(String[] words) {
        if (words == null || words.length == 0) return 0;
        int res = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());  // Sort the words based on their lengths
        HashMap<String, Integer> map = new HashMap();       //Stores each word and length of its max chain.

        for (String w : words) {                             //From shortest word to longest word
            map.put(w, 1);                                  //Each word is atleast 1 chain long
            for (int i = 0; i < w.length(); i++) {               //Form next word removing 1 char each time for each w
                StringBuilder sb = new StringBuilder(w);
                String next = sb.deleteCharAt(i).toString();
                if (map.containsKey(next) && map.get(next) + 1 > map.get(w))
                    map.put(w, map.get(next) + 1);            //If the new chain is longer, update the map
            }
            res = Math.max(res, map.get(w));                //Store max length of all chains
        }
        return res;
    }

    public int longestStrChainBackTracking(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (String word : words) {
            res = Math.max(res, helper(set, map, word));
        }
        return res;
    }

    private int helper(Set<String> set, Map<String, Integer> map, String word) {

        if (map.containsKey(word)) {
            return map.get(word);
        }

        StringBuilder sb = new StringBuilder(word);
        int res = 0;

        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            if (set.contains(sb.toString())) {
                res = Math.max(res, helper(set, map, sb.toString()));
            }
            sb.insert(i, word.charAt(i));
        }
        map.put(word, ++res);

        return res;
    }

    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<String>[] wordList = new List[17];
        for (String word : words) {
            int len = word.length();
            if (wordList[len] == null) {
                wordList[len] = new ArrayList<>();
            }
            wordList[len].add(word);
            map.put(word, 1);
        }
        int max = 1;
        for (int len = 1; len < 17; len++) {
            if (wordList[len] == null) continue;
            for (String word : wordList[len]) {
                int preLen = len - 1;
                if (wordList[preLen] == null) continue;
                for (String preWord : wordList[preLen]) {
                    if (isPre(preWord, word)) {
                        map.put(word,
                                Math.max(map.get(word), map.get(preWord) + 1));
                        max = Math.max(max, map.get(word));
                    }
                }

            }
        }
        return max;
    }

    private boolean isPre(String w1, String w2) {
        int p1 = 0, p2 = 0;
        boolean found = false;
        while (p1 < w1.length() && p2 < w2.length()) {
            if (w1.charAt(p1) == w2.charAt(p2)) {
                p1++;
                p2++;
            } else if (found) {
                return false;
            } else {
                found = true;
                p2++;
            }
        }
        return true;
    }

}
