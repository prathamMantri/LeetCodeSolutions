package leetcode.easy;

public class Solution1466 {

    public int maxPower(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int i = 1;
        int max = 0;
        int currLen = 0;
        while (i < s.length()) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                currLen++;
            } else {
                currLen = 0;
            }
            max = Math.max(currLen, max);
            i++;
        }
        return max + 1;
    }
}
