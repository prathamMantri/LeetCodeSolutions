package leetcode.easy;

public class Solution680 {
    boolean delete = false;

    public static void main(String[] args) {

        Solution680 sol = new Solution680();
        System.out.println(sol.validPalindrome("abcdefgdcba"));


    }

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (s.length() == 2) {
            return true;
        }
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (delete) {
                    return false;
                } else {
                    delete = true;
                    return validPalindrome(s.substring(i + 1, j + 1)) || validPalindrome(s.substring(i, j));
                }
            }

            i++;
            j--;
        }
        return true;
    }
}
