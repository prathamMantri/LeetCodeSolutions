package leetcode.medium;

public class Solution91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0')
                dp[i + 1] = dp[i] + dp[i + 1];
            int twoDigit = Integer.valueOf(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i + 1] = dp[i - 1] + dp[i + 1];
            }
        }
        return dp[s.length()];
    }


}
