package leetcode.hard;

public class Solution727 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        int sLen = s.length(), tLen = t.length(), sIndex = 0, tIndex = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        while (right < sLen) {

            //fast pointer, which will try to find first appearance of last character in 't'
            tIndex = 0;

            while (right < sLen) {

                if (s.charAt(right) == t.charAt(tIndex)) {
                    tIndex++;
                }
                //check if its reached to last char;
                if (tIndex == tLen)
                    break;

                right++;

            }
            //check if right reached to last char to 's';
            if (right == sLen) {
                break;
            }
            // start going backword, as you may find first character in t sooner than where you started, that will eventually give you less length.
            left = right;
            //going back means, tLen should start from end.
            tIndex = tLen - 1;

            while (left >= 0) {
                if (s.charAt(left) == t.charAt(tIndex)) {
                    tIndex--;
                }
                if (tIndex < 0)
                    break;
                left--;
            }
            //once you are at the start of t while coming back, just calculate the minimum length;
            if (minLen > right - left + 1) {
                minLen = right - left + 1;
                result = s.substring(left, right + 1);
            }
            right = left + 1;
        }
        return result;
    }
}
