package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution139 {

/*    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return s == null || s.equals("");
        }
        if (s == null || s.equals("")) {
            return wordDict.contains("");
        }
        return checkWordPresence(s, wordDict, 0, new Boolean[s.length()]);
    }

    private boolean checkWordPresence(String s, List<String> wordDict, int pos, Boolean[] memo) {
        if (pos == s.length()) {
            return true;
        }
        if (memo[pos] != null) {
            return memo[pos];
        }
        StringBuilder sb = new StringBuilder();
        while (pos < s.length()) {
            sb.append(s.charAt(pos));
            if (wordDict.contains(sb.toString())) {
                memo[pos] = true;
                if (checkWordPresence(s, wordDict, pos + 1, memo)) {
                    return true;
                }
                memo[pos] = false;
            }
            pos++;
        }
        return false;
    }*/


    public boolean wordBreakDP(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        if (set.size() == 0) {
            return s == null || s.equals("");
        }
        if (s == null || s.equals("")) {
            return set.contains("");
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String remaining = s.substring(j, i);
                if (dp[j] && set.contains(remaining)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
        //return checkWordPresence(s, wordDict, 0, new Boolean[s.length()]);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) return s == null || s.length() == 0;
        Set<String> set = new HashSet<>(wordDict);
        if (s == null || s.length() == 0) return set.contains("");
        Boolean[] memo = new Boolean[s.length() + 1];
        return findWord(s, set, 0, memo);
    }

    private boolean findWord(String s, Set<String> set, int pos, Boolean[] memo) {
        if (pos == s.length()) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        while (pos < s.length()) {
            sb.append(s.charAt(pos));
            if (set.contains(sb.toString())) {
                memo[pos] = memo[pos] != null ? memo[pos] && findWord(s, set, pos + 1, memo) : findWord(s, set, pos + 1, memo);
                if (memo[pos])
                    return true;
            }
            pos++;
        }
        return false;
    }

/*


    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
*/


}
