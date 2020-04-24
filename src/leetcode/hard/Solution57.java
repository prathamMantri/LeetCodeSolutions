package leetcode.hard;

public class Solution57 {


    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};

        Solution57 sol = new Solution57();
        sol.insert(intervals, newInterval);

    }

    /***
     *
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to their start times.
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[6,9}], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Example 2:
     *
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     *
     */

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        int startPoint = 0, endPoint = 0;

        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        int i = 0, j = 0;
        ////   while(true){
        if (newInterval[0] >= startTime[i]) {

        }
        //     }
        return intervals;
    }


}
