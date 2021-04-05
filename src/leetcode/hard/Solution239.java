package leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length)
            return new int[0];
        Deque<Integer> deq = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int i = 0;
        while (i < nums.length) {
            // check if an element is going out of the windowSo
            if (!deq.isEmpty() && deq.peekFirst() == i - k) {
                deq.pollFirst(); // remove that element from first
            }
            while (!deq.isEmpty() && nums[deq.peekFirst()] < nums[i]) {
                deq.pollLast();
            }
            deq.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deq.peekFirst()];
            }
            i++;
        }
        return res;
    }


    public int[] maxSlidingWindowWrong(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];

        int start = 0;
        int firstMax = nums[0];
        int secondMax = nums[0];
        int firstMaxIndex = 0;
        int secondMaxIndex = 0;

        //      1    3    -1
        //          i
        //          f
        //      s
        for (int i = 0; i < k - 1; i++) {
            if (nums[firstMaxIndex] < nums[i]) {
                secondMaxIndex = firstMaxIndex;
                secondMax = nums[secondMaxIndex];
                firstMaxIndex = i;
                firstMax = nums[i];
            }
        }
        res[0] = firstMax;
        int nextMax = firstMaxIndex == start ? secondMax : firstMax;
        start++;

        while (start <= nums.length - k) {
            if (nums[start + k - 1] > nextMax) {
                res[start] = nums[start + k - 1];
            } else {
                res[start] = nextMax;
            }
            nextMax = firstMaxIndex == start ? secondMax : firstMax;
            start++;
        }
        return res;
    }
}
