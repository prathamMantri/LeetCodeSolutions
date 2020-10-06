package leetcode.hard;

public class Solution214 {
    public String shortestPalindromeBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        String reverse = sb.reverse().toString();
        for (int i = 0; i < s.length() - 1; i++)
            if (s.substring(0, s.length() - 1).equals(reverse.substring(i)))
                return reverse.substring(0, i) + s;
        return "";
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int i = 0;
        int j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }
        if (i == s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.substring(i));
        String reverse = sb.reverse().toString();
        return reverse + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }
}
