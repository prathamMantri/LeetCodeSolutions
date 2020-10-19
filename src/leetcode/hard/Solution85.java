package leetcode.hard;

import java.util.Stack;

public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int currentArea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
            }
            currentArea = findHistogramArea(dp);
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }

    private int findHistogramArea(int[] heights) {
        int top = 0;
        int area = 0;
        int maxArea = 0;
        int i = 0;
        /*
        The logic is keep adding number unless current number is less than previous number
        if it is
            keep removing number from stack untill you find the number which is less than or equal to current number, while doing so, calculate the area, by below formula

        if stack becomes empty
            area = heights[top] * i;
        else
            area = heights[top] * (i - stack.top  - 1) // here st.top meaning, stack's current top after popping the element and top meaning, stack's popped element; This is very much important to remember and not to be confused.
        maxArea = Math.max(area, maxArea);

        return the maxArea;
        */

        Stack<Integer> st = new Stack<>();

        while (i < heights.length) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i++);
            } else {
                top = st.pop();
                if (st.isEmpty())
                    area = heights[top] * i;
                else
                    area = heights[top] * (i - st.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        while (!st.isEmpty()) {
            top = st.pop();
            if (st.isEmpty())
                area = heights[top] * i;
            else
                area = heights[top] * (i - st.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }

}
