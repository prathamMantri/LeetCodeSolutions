package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution446 {
    /**
     *
     * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
     *
     * Example:
     *
     * MovingAverage m = new MovingAverage(3);
     * m.next(1) = 1
     * m.next(10) = (1 + 10) / 2
     * m.next(3) = (1 + 10 + 3) / 3
     * m.next(5) = (10 + 3 + 5) / 3
     *
     */

    /**
     * Initialize your data structure here.
     */

    int size;
    Queue<Integer> window = new LinkedList<>();
    int sum = 0;

    public Solution446(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        Solution446 sol = new Solution446(3);
        System.out.println(sol.next(1));
        System.out.println(sol.next(10));
        System.out.println(sol.next(3));
        System.out.println(sol.next(5));
    }

    public double next(int val) {
        if (window.size() == size) {
            sum = sum - window.poll() + val;
            window.add(val);
            return sum / window.size();
        }
        sum = val + sum;
        window.add(val);
        return sum / window.size();
    }
}
