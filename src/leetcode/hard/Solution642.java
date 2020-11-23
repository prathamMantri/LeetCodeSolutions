package leetcode.hard;

import model.TrieNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution642 {

    public static class AutocompleteSystem {

        TrieNode root;
        String prefix;

        public AutocompleteSystem(String[] sentences, int[] times) {
            // Initialize
            root = new TrieNode();
            prefix = "";

            for (int i = 0; i < sentences.length; i++) {
                add(sentences[i], times[i]);
            }
        }

        void add(String s, int count) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                TrieNode next = curr.getNodes().get(c);
                if (next == null) {
                    next = new TrieNode();
                    curr.getNodes().put(c, next);
                }
                curr = next;
                curr.getCountMap().put(s, curr.getCountMap().getOrDefault(c, 0) + count);
            }
            curr.setEnd();
        }

        public List<String> input(char c) {
            if (c == '#') {
                add(prefix, 1);
                prefix = "";
                return new ArrayList<>();
            }

            prefix = prefix + c;
            TrieNode curr = root;

            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.getNodes().get(cc);
                if (next == null) {
                    return new ArrayList<>();
                }
                curr = next;
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.sentence.compareTo(b.sentence) : b.count - a.count);
            for (String s : curr.getCountMap().keySet()) {
                pq.add(new Pair(s, curr.getCountMap().get(s)));
            }
            List<String> res = new ArrayList<>();
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(pq.poll().sentence);
            }
            return res;
        }

        class Pair {
            String sentence;
            Integer count;

            public Pair(String sentence, int count) {
                this.sentence = sentence;
                this.count = count;
            }
        }
    }
    /**
     *  Your AutocompleteSystem object will be instantiated and called as such:
     *  AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
     *  List<String> param_1 = obj.input(c);
     */

}
