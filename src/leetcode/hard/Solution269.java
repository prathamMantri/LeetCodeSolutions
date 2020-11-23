package leetcode.hard;

import java.util.*;

public class Solution269 {
    public String alienOrder(String[] words) {
        //Step 1: Initialisation
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();

        //Step 2: Create graph and assign degree
        for (int i = 1; i < words.length; i++) {

            String word1 = words[i - 1];
            String word2 = words[i];

            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    map.computeIfAbsent(word1.charAt(j), k -> new ArrayList<>()).add(word2.charAt(j));
                    degree.put(word2.charAt(j), degree.getOrDefault(word2.charAt(j), 0) + 1);
                }
            }
        }

        Queue<Character> q = new LinkedList<>();

        for (char c : degree.keySet()) {
            if (degree.get(c) == 0)
                q.offer(c);
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char next : map.get(c)) {
                degree.put(next, degree.get(next) - 1);
                if (degree.get(next) == 0)
                    q.offer(c);
            }
        }
        return sb.toString();

    }
}
