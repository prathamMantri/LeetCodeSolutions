package leetcode.medium;

import java.util.Stack;

public class Solution735 {
    public int[] asteroidCollisionOld(int[] asteroids) {
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


    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty() || a[i] > 0) {
                stack.push(a[i]);
                continue;
            }

            while (true) {
                int prev = stack.peek();
                if (prev < 0) {
                    stack.push(a[i]);
                    break;
                }
                if (prev == -a[i]) {
                    stack.pop();
                    break;
                }
                if (prev > -a[i]) {
                    break;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(a[i]);
                    break;
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

}
