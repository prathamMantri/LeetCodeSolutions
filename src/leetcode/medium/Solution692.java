package leetcode.medium;

import java.util.*;

public class Solution692 {

    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> wordCountMap.get(a).equals(wordCountMap.get(b)) ? a.compareTo(b) : wordCountMap.get(a) - wordCountMap.get(b));
        maxHeap.addAll(wordCountMap.keySet());

        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}
