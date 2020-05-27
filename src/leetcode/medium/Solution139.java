package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution139 {

    public static void main(String[] args) {
        Solution139 sol = new Solution139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("go");
        wordDict.add("goal");
        wordDict.add("goals");
        wordDict.add("special");

        System.out.println(sol.wordBreak("goalspecial", wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
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
    }


}
