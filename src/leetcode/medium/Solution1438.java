package leetcode.medium;

import java.util.PriorityQueue;

public class Solution1438 {

    //Time limit reached with below code

    /*  public int longestSubarray(int[] nums, int limit) {
        if(nums.length == 1 && limit == 0){
            return 2;
        }
        int i=0, j=0, size=0;
        int high=0, low=0;

        while(j<nums.length){
            high = nums[j] >= nums[high] ? j : high;
            low = nums[j] <= nums[low] ? j : low;
            if(Math.abs(nums[high] - nums[low]) <= limit){
                size = size > (j-i+1) ? size : j-i+1;
            }else{
                if(nums[low] < j){
                    i = low + 1;
                }else{
                    i = high + 1;
                }
                j = i;
                high = low = i;
            }
            j++;
        }
        return size;
    }*/

    ///Use this code

    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 1 && limit == 0) {
            return 2;
        }
        int i = 0, j = 0, size = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        minHeap.offer(nums[i]);
        maxHeap.offer(nums[j]);

        while (j < nums.length) {
            if (Math.abs(maxHeap.peek() - minHeap.peek()) <= limit) {
                size = Math.max(size, (j - i + 1));
                j++;
                if (j < nums.length) {
                    minHeap.offer(nums[j]);
                    maxHeap.offer(nums[j]);
                }
            } else {
                minHeap.remove(nums[i]);
                maxHeap.remove(nums[i]);
                i++;
            }
        }
        return size;
    }


}
