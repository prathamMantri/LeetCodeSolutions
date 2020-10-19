package leetcode.easy;

public class Solution1614 {

    public int maxDepth(String s) {

        int max = 0;
        int current = 0;
        int bracket = 0;

        if (s == null || s.length() == 0)
            return 0;

        int i = 0;


        while (i < s.length()) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                i++;
                continue;
            } else if (s.charAt(i) == '(') {
                bracket++;
                current++;
            } else {
                bracket--;
                max = Math.max(current, max);
                if (bracket == 0) {
                    current = 0;
                }
            }

            i++;
        }

        return max;


    }

}
