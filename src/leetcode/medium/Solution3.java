package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, count = 0;
        int n = s.length();

        for (int i = 0, j = 0; j < n; j++) {

            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                count++;
                max = Math.max(count, max);
            } else {
                i = map.get(s.charAt(j));
                j = map.get(s.charAt(j));
                count = 0;
                map.clear();
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }
}