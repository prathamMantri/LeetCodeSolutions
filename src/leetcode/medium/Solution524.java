package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution524 {
    public static void main(String[] args) {

        Solution524 sol = new Solution524();

        List<String> list = new ArrayList<>();

        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");

        System.out.println(sol.findLongestWord("abcplea", list));

    }

    public String findLongestWord(String s, List<String> d) {

        String res = "";

        if (s == null || s.equals("") || d == null || d.size() == 0) {
            return null;
        }

        List<Character> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            list.add(c);
        }

        int max = 0;

        for (String word : d) {

            int len = word.length();
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (!list.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag && len > max) {
                res = word;
                max = len;
            }
        }
        return res;
    }
}
