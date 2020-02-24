package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution253 {


    public static void main(String[] args) {

        Solution253 sol = new Solution253();
        int[][] intervals = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        System.out.println(sol.minMeetingRooms(intervals));


    }

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     * <p>
     * Example 1:
     * <p>
     * Input: [[0, 30],[5, 10],[15, 20]]
     * Output: 2
     * Example 2:
     * <p>
     * Input: [[7,10],[2,4]]
     * Output: 1
     *
     * @param intervals
     * @return
     */

    //Solution through priority Queue or min heap data structure where minimum ending time is being tracked.
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> rooms =
                new PriorityQueue<>(intervals.length, Comparator.comparingInt(o -> o));

        rooms.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= rooms.peek()) {
                rooms.poll();
            }
            rooms.add(intervals[i][1]);
        }
        return rooms.size();
    }


}
