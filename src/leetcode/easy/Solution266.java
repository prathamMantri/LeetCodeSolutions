package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution266 {
    public boolean canPermutePalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                set.remove(s.charAt(i));
            }
        }

        return set.size() <= 1;

    }
}
