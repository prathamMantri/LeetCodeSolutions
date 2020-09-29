package leetcode.medium;

public class Solution5 {

/*

    public String longestPalindrome(String s) {
        char[] chArr = s.toCharArray();
        int min = 0;
        int max = 0;
        int pointer = 0;

        while (pointer < chArr.length - 1 && max < chArr.length - 1) {
            int curMax = pointer;
            int curMin = pointer;

            //let the pointer run as long as the current char is repeated
            while (curMax < chArr.length - 1 && chArr[pointer] == chArr[curMax + 1])
                curMax++;
            while (curMin > 0 && chArr[pointer] == chArr[curMin - 1])
                curMin--;

            //expand both points to each side as long as the chars are equal
            while (curMin > 0 && curMax < chArr.length - 1 && chArr[curMin - 1] == chArr[curMax + 1]) {
                curMax++;
                curMin--;
            }

            //checks whether current palindrome's length is bigger than the one we already marked
            if (curMax - curMin > max - min) {
                min = curMin;
                max = curMax;
            }
            pointer++;
        }

        StringBuilder ans = new StringBuilder(min + max);
        for (int i = min; i <= max; i++)
            ans.append(chArr[i]);

        return ans.toString();
    }

*/
int st, en;

    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        System.out.println(sol.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(st + 1, en);
    }

    private void expand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (en - st - 1 <= end - start - 1) {
            st = start;
            en = end;
        }
    }
}
