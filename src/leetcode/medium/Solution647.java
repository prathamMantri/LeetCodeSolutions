package leetcode.medium;

public class Solution647 {
    public int countSubstrings(String s) {
        int count = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int d = 0; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (i + 1 >= j - 1) || dp[i + 1][j - 1];
                    if (dp[i][j]) count++;
                }
            }
        }
        return count;
    }
}
