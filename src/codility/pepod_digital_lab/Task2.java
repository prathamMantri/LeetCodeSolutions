package codility.pepod_digital_lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Task2 {

    public int solution(String S) {
        // write your code in Java SE 8

        if (S == null || S.length() == 0) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (char c : S.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }


        Set<Character> keySet = count.keySet();

        for (Character c : keySet) {
            if (count.get(c) % 2 != 0) {
                res++;
            }
        }
        return res;


    }


}
