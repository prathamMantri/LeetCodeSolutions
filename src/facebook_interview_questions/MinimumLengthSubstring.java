package facebook_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class MinimumLengthSubstring {

    public static void main(String[] args) {
        MinimumLengthSubstring min = new MinimumLengthSubstring();
        System.out.println(min.minLengthSubstring("dcbefebce", "fd"));
    }

    int minLengthSubstring(String s, String t) {

        List<Character> tList = new ArrayList<>();
        int[] indexes = new int[26];
        int[] tIndexes = new int[26];

        for (char c : t.toCharArray()) {
            tList.add(c);
            tIndexes[c - 'a'] = tIndexes[c - 'a'] + 1;
        }

        int i = 0, j = 0, len, minLen = s.length(), count = 0;

        while (i < s.length()) {
            char c = s.charAt(i);
            while (count < t.length()) {
                if (tList.contains(c) && indexes[c - 'a'] != 0) {
                    indexes[c - 'a'] = indexes[c - 'a'] - 1;
                    count++;
                }
                i++;
            }

          /*  len = indexes.get(indexes.size() - 1) - indexes.get(0) + 1;
            minLen = Math.min(len, minLen);
            int temp = indexes.remove(0);*/
            //    i = indexes.get(indexes.size() - 1);
        }
        return minLen;
    }

}
