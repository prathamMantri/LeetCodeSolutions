package leetCode.medium;

import java.util.Deque;
import java.util.LinkedList;

class Solution11 {
    public int maxArea(int[] height) {
        Deque<Integer> histogram = new LinkedList<>();
        int currentArea = 0;
        int maxArea = 0;
        int i;
        for (i = 0; i < height.length; ) {
            if (histogram.isEmpty() || height[histogram.peek()] <= height[i]) {
                histogram.offerFirst(i++);
            } else {
                int top = histogram.pollFirst();
                if (histogram.isEmpty()) {
                    currentArea = height[top] * i;
                } else {
                    currentArea = height[top] * (i - histogram.peek() - 1);
                }
                maxArea = Math.max(maxArea, currentArea);
            }
        }

        while (!histogram.isEmpty()) {
            int top = histogram.pollFirst();
            if (histogram.isEmpty()) {
                currentArea = height[top] * i;
            } else {
                currentArea = height[top] * (i - histogram.peekFirst() - 1);
            }
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;

    }
}