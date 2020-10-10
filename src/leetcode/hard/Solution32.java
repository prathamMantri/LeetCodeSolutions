package leetcode.hard;

public class Solution32 {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, len = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                len = left + right;
            if (right > left)
                left = right = 0;
            max = Math.max(len, max);
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;
            if (left == right)
                len = left + right;
            if (left > right)
                left = right = 0;
            max = Math.max(len, max);
        }
        return max;
    }
}
