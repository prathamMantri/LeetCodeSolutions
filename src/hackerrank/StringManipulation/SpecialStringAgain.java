package hackerrank.StringManipulation;

public class SpecialStringAgain {
    /*

        A string is said to be a special string if either of two conditions is met:


        All of the characters are the same, e.g. aaa.
        All characters except the middle one are the same, e.g. aadaa.
        A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

        For example, given the string , we have the following special substrings: .

        Function Description

        Complete the substrCount function in the editor below. It should return an integer representing the number of special substrings that can be formed from the given string.

        substrCount has the following parameter(s):

        n: an integer, the length of string s
        s: a string
        Input Format

        The first line contains an integer, , the length of .
        The second line contains the string .

        Constraints


        Each character of the string is a lowercase alphabet, .

        Output Format

        Print a single line containing the count of total special substrings.

        Sample Input 0

        5
        asasd
        Sample Output 0

        7
        Explanation 0

        The special palindromic substrings of  are

        Sample Input 1

        7
        abcbaba
        Sample Output 1

        10
        Explanation 1

        The special palindromic substrings of  are

        Sample Input 2

        4
        aaaa
        Sample Output 2

        10
        Explanation 2

        The special palindromic substrings of  are

        https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

     */


    public long substrCount(int n, String s) {

        if (n == 0) {
            return 0;
        }
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = count + expandAroundCenter(s, i, i);
            count = count + expandAroundCenter(s, i, i + 1);
        }
        return count;
    }

    long expandAroundCenter(String s, int start, int end) {
        int count = 0;

        int lo = start;
        int hi = end;
        char c;
        boolean odd = end == start;

        while (lo >= 0 && hi < s.length()) {
            if (odd)
                c = start > 0 ? s.charAt(start - 1) : s.charAt(start);
            else
                c = s.charAt(start);

            if (s.charAt(lo) != c || s.charAt(hi) != c) {
                break;
            }
            lo--;
            hi++;
            count++;
        }

        return count;
    }
}
