package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Solution564 {
    public String nearestPalindromic(String n) {
        // edge cases, no

        int len = n.length();
        int i = len % 2 == 0 ? len / 2 - 1: len / 2;
        long left = Long.parseLong(n.substring(0, i+1));

        // input: n 12345
        List<Long> candidate = new ArrayList<>();
        candidate.add(getPalindrome(left, len % 2 == 0)); // 12321
        candidate.add(getPalindrome(left+1, len % 2 == 0)); // 12421
        candidate.add(getPalindrome(left-1, len % 2 == 0)); // 12221
        candidate.add((long)Math.pow(10, len-1) - 1); // 9999
        candidate.add((long)Math.pow(10, len) + 1); // 100001

        long diff = Long.MAX_VALUE, res = 0, nl = Long.parseLong(n);
        for (long cand : candidate) {
            if (cand == nl) continue;
            if (Math.abs(cand - nl) < diff) {
                diff = Math.abs(cand - nl);
                res = cand;
            } else if (Math.abs(cand - nl) == diff) {
                res = Math.min(res, cand);
            }
        }

        return String.valueOf(res);
    }

    private long getPalindrome(long left, boolean even) {
        long res = left;
        if (!even) left = left / 10;
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }

    public static void main(String[] args){
        Solution564 sol = new Solution564();
        System.out.println(sol.nearestPalindromic("1234"));
    }

}
