package leetcode.hard;

public class Solution44 {

    //if asked in interview, use this code
    public boolean isMatch(String str, String pattern) {
        int sIndex = 0, pIndex = 0, match = 0, starIndex = -1;
        while (sIndex < str.length()) {
            // advancing both pointers
            if (pIndex < pattern.length() && (pattern.charAt(pIndex) == '?' || str.charAt(sIndex) == pattern.charAt(pIndex))) {
                sIndex++;
                pIndex++;
            }
            // * found, only advancing pattern pointer
            else if (pIndex < pattern.length() && pattern.charAt(pIndex) == '*') {
                starIndex = pIndex;
                match = sIndex;
                pIndex++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIndex != -1) {
                pIndex = starIndex + 1;
                match++; // match is containing the character which you can skip at each backtrack. for every backtrack,match increases, so that same sIndex do not start from same index again.
                sIndex = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (pIndex < pattern.length() && pattern.charAt(pIndex) == '*')
            pIndex++;

        return pIndex == pattern.length();
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
