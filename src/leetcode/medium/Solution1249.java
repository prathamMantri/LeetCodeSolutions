package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1249 {
    public static void main(String[] args) {

        Solution1249 sol = new Solution1249();
        System.out.println(sol.minRemoveToMakeValid("(a(b(c)d)"));

    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        List<Integer> rm = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            if (st.isEmpty() && s.charAt(i) == ')') {
                rm.add(i);
                continue;
            }
            if (s.charAt(i) == '(') {
                st.add(0);
            }
            if (s.charAt(i) == ')') {
                st.add(1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!rm.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        int zero = 0;
        int one = 0;

        while (!st.empty()) {

            if (st.pop() == 0) {
                zero++;
            } else {
                one++;
            }
        }
        return rmFromString(sb.toString(), zero > one ? '(' : ')', Math.abs(zero - one));
    }

    String rmFromString(String s, char c, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c && count > 0) {
                count--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
