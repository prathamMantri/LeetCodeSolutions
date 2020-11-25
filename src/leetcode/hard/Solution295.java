package leetcode.hard;

import java.util.PriorityQueue;

public class Solution295 {
    class MedianFinder {

        /**
         * initialize your data structure here.
         */

        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;
        boolean even;

        public MedianFinder() {
            max = new PriorityQueue<>();
            min = new PriorityQueue<>((a, b) -> b - a);
            even = true;
        }

        public void addNum(int num) {
            if (even) {
                max.offer(num);
                min.offer(max.poll());
            } else {
                min.offer(num);
                max.offer(min.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if (even)
                return (max.peek() + min.peek()) / 2.0;
            return min.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
