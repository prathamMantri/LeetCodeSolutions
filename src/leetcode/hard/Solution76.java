package leetcode.hard;

public class Solution76 {

    public String minimumWindow(String s, String t) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        boolean windoStarted = false;
        //Define map or array
        int[] letterCount = new int[128];
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, count = 0;
        // Increment with t chars
        for (char c : t.toCharArray()) {
            ++letterCount[c];
        }
        //**********************Optimization************************************
        // Keep on increasing the left until you find a character from t in s
        while (left < s.length()) {
            if (letterCount[s.charAt(left++)] > 0) {
                break;
            }
        }
        left--;
        right = left;
        //********************************************************
        // now start expanding the window.
        for (; right < s.length(); ++right) {
            // if found, increase the count
            if (--letterCount[s.charAt(right)] >= 0) {
                ++count;
            }
            // if count is equal to the t.length, get the window length and if window length is smaller than previosuly calculated window length
            // update the result string using s.substring method.
            while (count == t.length()) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                // once you have the window length, now move the left pointer to right by 1 and decrement the count as, we are removing it from our already counted data, but increment the array.

                if (++letterCount[s.charAt(left)] > 0)
                    --count;
                ++left;
            }
        }
        return res;
    }

    public String minimumWindow2(String s, String t) {

        //Define map or array
        int[] map = new int[128];
        // Increment with t chars
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        // Define required variables
        int start = 0; // start of scanning/ window/left
        int end = 0; // window right side/end, which will eventually get expanded.
        int minStart = 0; //
        int minLength = Integer.MAX_VALUE; // Initialize with MAX value as we have to find minimum window.
        int counter = t.length(); // counter to check whether, all chars in t are counted in window.

        while (end < s.length()) {
            char c1 = s.charAt(end);

            if (map[c1] > 0)
                counter--; // if value is greater than 1, meaning its presence in t, decrement its count and counter too
            map[c1]--;
            end++; // expand the right counter

            //if counter becomes 0;
            while (counter == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
