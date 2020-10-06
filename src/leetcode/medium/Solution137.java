package leetcode.medium;

import java.util.*;

public class Solution137 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                assert currentWord != null;
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < currentWord.length(); j++) {
                    char original = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == charArray[j]) continue;
                        charArray[j] = c;
                        String newWord = String.valueOf(charArray);
                        if (endWord.equals(newWord)) return steps + 1;
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    charArray[j] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}
