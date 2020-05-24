package leetcode.medium;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        System.out.println(sol.longestPalindrome("abacdfgdcaba"));
    }

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

}
