package leetcode.medium;

import java.util.*;

public class Solution347 {
/*
    Given a non-empty array of integers, return the k most frequent elements.

            Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    Example 2:

    Input: nums = [1], k = 1
    Output: [1]
    Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

    public int[] topKFrequentHeap(int[] nums, int k) {
        int[] result = new int[k];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (Integer num : nums) {
            numberCount.put(num, numberCount.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> numberCount.get(a) - numberCount.get(b));
        for (Integer num : numberCount.keySet()) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    ///// do not use this

    public List<Integer> topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(countMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });


        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;

    }


}
