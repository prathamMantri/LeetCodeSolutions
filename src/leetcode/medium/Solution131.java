package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {


    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p>
     * Return all possible palindrome partitioning of s.
     * <p>
     * Example:
     * <p>
     * Input: "aab"
     * Output:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     *
     * @param s
     * @return
     */


    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, String s, int low) {
        if (low == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int high = low; high < s.length(); high++) {
            if (isPalindrome(s, low, high)) {
                list.add(s.substring(low, high + 1));
                helper(res, list, s, high + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
}
