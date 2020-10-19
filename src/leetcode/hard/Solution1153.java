package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution1153 {
    public boolean canConvert(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;


        if (str1.equals(str2))
            return true;

        Map<Character, Character> map = new HashMap<>();


        for (int i = 0; i < str1.length(); i++) {

            if (map.containsKey(str1.charAt(i)) && map.get(str1.charAt(i)) != str2.charAt(i))
                return false;
            map.put(str1.charAt(i), str2.charAt(i));
        }
        // Remember, you want values not to go beyond 25. Keys can go beyond 26
        return new HashSet<Character>(map.values()).size() < 26;


    }
}
