package leetcode.medium;

import java.util.Stack;

public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        st.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            Integer prev = st.isEmpty() ? null : st.peek();
            int curr = asteroids[i];
            if (prev != null) {
                if (prev * (-1) == curr && prev > 0) {
                    st.pop();
                } else if (prev > 0 && curr > 0) {
                    st.push(curr);
                } else if (prev < 0 && curr < 0) {
                    st.push(curr);
                } else if (prev < 0 && curr > 0) {
                    st.push(curr);
                } else {
                    while (!st.isEmpty() && prev > curr) {
                        if (Math.abs(prev) < Math.abs(curr) && prev > 0) {
                            st.pop();
                            if (!st.isEmpty()) {
                                prev = st.peek();
                            }
                        } else {
                            break;
                        }
                    }
                    if (prev * (-1) == curr && prev > 0) {
                        st.pop();
                    } else if (prev < 0) {
                        st.push(curr);
                    } else if (st.isEmpty()) {
                        st.push(curr);
                    }
                }
            } else {
                st.push(curr);
            }
        }

        int[] res = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            res[i] = st.pop();
            i++;
        }

        i = res.length - 1;
        int j = 0;
        while (i >= j) {
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i--;
            j++;
        }
        return res;
    }
}
