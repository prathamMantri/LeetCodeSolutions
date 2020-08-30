package leetcode.easy;

public class Solution520 {
    public static void main(String[] args) {
        Solution520 sol = new Solution520();
        System.out.println(sol.detectCapitalUse("Test"));
        System.out.println(sol.detectCapitalUse("test"));
        System.out.println(sol.detectCapitalUse("TEST"));
        System.out.println(sol.detectCapitalUse("TEsT"));
        System.out.println(sol.detectCapitalUse("TeST"));
        System.out.println(sol.detectCapitalUse("TeSt"));
        System.out.println(sol.detectCapitalUse("TEst"));
        System.out.println(sol.detectCapitalUse(""));
    }

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        char[] chars = word.toCharArray();

        boolean firstCharUpper = Character.isUpperCase(chars[0]);
        boolean allCharUpper = true;
        boolean noCharUpper = true;

        for (int i = 1; i < chars.length; i++) {
            allCharUpper = Character.isUpperCase(chars[i]) && allCharUpper;
            noCharUpper = Character.isLowerCase(chars[i]) && noCharUpper;
        }

        return firstCharUpper ? (allCharUpper || noCharUpper) : noCharUpper;

    }


}
