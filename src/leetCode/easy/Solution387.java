package leetCode.easy;

import java.util.HashMap;
import java.util.Set;

class Solution387 {
    public static void main(String[] args) {
        Solution387 sol = new Solution387();
        sol.firstUniqChar("cc");

    }

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> unique = new HashMap<>();
        int index = 0;
        for (Character ch : s.toCharArray()) {
            if (unique.containsKey(ch)) {
                unique.put(ch, -1);
            } else {
                unique.put(ch, index);
            }
            index++;
        }

        Set<Character> uniqueCharSet = unique.keySet();

        int min = s.length();
        for (Character uniqueChar : uniqueCharSet) {
            if (unique.get(uniqueChar) != -1) {
                if (unique.get(uniqueChar) < min) {
                    min = unique.get(uniqueChar);
                }
            }
        }
        return min;
    }
}