package leetcode.hard;

public class Solution44 {

    //if asked in interview, use this code
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
    /*
        public boolean isMatch(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();

        int sIndex = 0;
        int pIndex = 0;

        int starIndex = -1;
        int sTempIndex = -1;

        while (sIndex < sLength) {
            //If pattern character is '?', or pattern character matches string character
            // increase the pointer
            if (pIndex < pLength && (p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex))) {
                ++pIndex;
                ++sIndex;
            }
            // if pattern character is '*'
            else if (pIndex < pLength && p.charAt(pIndex) == '*') {
                //situation when '*' matches no characters
                starIndex = pIndex;
                sTempIndex = sIndex;
                ++pIndex;
            }
            // if pattern character != string character or pattern is used up
            // and no * character in pattern.
            else if (starIndex == -1) {
                return false;
            } else {
                // if pattern character != string character
                // or pattern is used up
                // and was a * character in pattern before.
                pIndex = starIndex + 1;
                sIndex = sTempIndex + 1;
                sTempIndex = sIndex;
            }
        }
        /// if pattern length is more than string length, then remaining characters should be *.
        for (int i = pIndex; i < pLength; i++)
            if (p.charAt(i) != '*')
                return false;
        return true;
    }
    */


}
