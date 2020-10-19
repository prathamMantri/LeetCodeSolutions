package leetcode.medium;

public class Solution1616 {

    /**
     *
     *You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.
     *
     * When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
     *
     * Return true if it is possible to form a palindrome string, otherwise return false.
     *
     * Notice that x + y denotes the concatenation of strings x and y.
     *
     *
     *
     * Example 1:
     *
     * Input: a = "x", b = "y"
     * Output: true
     * Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
     * aprefix = "", asuffix = "x"
     * bprefix = "", bsuffix = "y"
     * Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
     * Example 2:
     *
     * Input: a = "abdef", b = "fecab"
     * Output: true
     * Example 3:
     *
     * Input: a = "ulacfd", b = "jizalu"
     * Output: true
     * Explaination: Split them at index 3:
     * aprefix = "ula", asuffix = "cfd"
     * bprefix = "jiz", bsuffix = "alu"
     * Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
     * Example 4:
     *
     * Input: a = "xbdef", b = "xecab"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= a.length, b.length <= 105
     * a.length == b.length
     * a and b consist of lowercase English letters
     */


    /***
     *
     *
     *
     * @param a
     * @param b
     * @return
     */


    public boolean checkPalindromeFormation(String a, String b) {
        return validate(a, b) || validate(b, a);
    }

    private boolean validate(String a, String b) {
        int l = 0, r = a.length() - 1;
        while (l < r) {
            if (a.charAt(l) != b.charAt(r))
                break;
            l++;
            r--;
        }

        return validate(a, l, r) || validate(b, l, r);
    }

    private boolean validate(String a, int l, int r) {
        while (l < r) {
            if (a.charAt(l) != a.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }


    /*
    public boolean checkPalindromeFormation(String a, String b) {
        // Solution logic is below

        // case1: a is Palindrome
        // case2: b is Palindrome
        // case3: left part of A + right part of B is Palindrome
        // case4: left part of B + right part of A is Palindrome
        // then use two pointers to check if any case is valid


        int n = a.length();
        if(n == 1){
            return true;
        }
        int start = 0;
        int end = n - 1;
        while(start < end){
            if(b.charAt(start) == a.charAt(end) ||
                    a.charAt(start) == b.charAt(end) ||
                    a.charAt(start) == a.charAt(end) ||
                    b.charAt(start) == b.charAt(end)){
                start++;
                end--;
            } else return false;
        }
        return true;
    }*/


}
