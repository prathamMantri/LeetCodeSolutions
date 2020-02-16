package leetcode.easy;

public class Solution125 {
    public static void main(String[] args) {
        Solution125 sol = new Solution125();
        System.out.println(sol.isPalindrome("`l;`` 1o1 ??;l`"));
    }

    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
        String str2 = str.replaceAll("\\s", "");
        int start = 0;
        int end = str2.length() - 1;
        while (start <= end) {
            if (str2.charAt(start) != str2.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
