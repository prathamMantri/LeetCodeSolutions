package leetcode.medium;

import java.util.Stack;

// 1 2 3 4 5
// 4 5 3 2 1

//2 1 0
//1 2 0

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || pushed.length == 0) {
            return true;
        }
        Stack<Integer> st = new Stack<>();
        int i = 0, j = 0;
        while (true) {
            if (j == popped.length) {
                return st.isEmpty();
            }
            if (!st.isEmpty()) {
                if (popped[j] == st.peek()) {
                    st.pop();
                    j++;
                } else if (i < pushed.length) {
                    st.push(pushed[i++]);
                } else {
                    return false;
                }
            } else {
                if (i < pushed.length)
                    st.push(pushed[i++]);
                else
                    return false;
            }
        }
    }
}
