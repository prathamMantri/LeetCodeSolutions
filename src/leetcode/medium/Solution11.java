package leetcode.medium;

class Solution11 {
    /*public int maxArea(int[] height) {
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

    }*/

    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(sol.maxArea(height));


    }

    public int maxArea(int[] height) {
        if (height.length == 0)
            return 0;
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            maxArea = Math.max(area, maxArea);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

}
