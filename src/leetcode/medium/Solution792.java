package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution792 {
    /*public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new LinkedList<>());
        }
        for(String word : words) {
            char c = word.charAt(0);
            if(map.containsKey(c)) {
                map.get(c).offer(word);
            }
        }
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            Queue<String> q = map.get(c);
            int size = q.size();
            for(int k = 0; k < size; k++) {
                String str = q.poll();
                if(str.length() == 1) {
                    count++;
                } else {
                    if(map.containsKey(str.charAt(1))) {
                        map.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }
        return count;
    }*/

    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> charMap = new HashMap<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            charMap.putIfAbsent(c, new LinkedList<>()); // initialize the map with characters and their words.
        }
        for (String word : words) {
            if (charMap.containsKey(word.charAt(0))) {
                Queue<String> queue = charMap.get(word.charAt(0));
                queue.offer(word);
                charMap.put(word.charAt(0), queue);
            }
        }
        for (char c : S.toCharArray()) {
            Queue<String> queue = charMap.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.length() == 1)
                    count++;
                else if (charMap.containsKey(word.charAt(1)))
                    charMap.get(word.charAt(1)).offer(word.substring(1));
            }
        }
        return count;
    }
}
