package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {

    /*
    *
    *
    *
    *   Given a collection of intervals, merge all overlapping intervals.

        Example 1:

        Input: [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
        Example 2:

        Input: [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    *
    *
    * */


    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> mergedIntervals;
        int start = intervals[0][0];
        int end = intervals[0][1];

        int i = 1;

        while (i < intervals.length) {

            if (end >= intervals[i][0] && end >= intervals[i][1]) {
                i++;
                continue;
            } else if (end >= intervals[i][0]) {
                end = intervals[i][1];
            } else {
                mergedIntervals = new ArrayList<>();
                mergedIntervals.add(start);
                mergedIntervals.add(end);
                res.add(mergedIntervals);
                start = intervals[i][0];
                end = intervals[i][1];
            }
            i++;
        }

        mergedIntervals = new ArrayList<>();
        mergedIntervals.add(start);
        mergedIntervals.add(end);
        res.add(mergedIntervals);
        int[][] result = new int[res.size()][2];
        for (i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }
        return result;
    }

    public static void main(String[] args) {

        Solution56 solution56 = new Solution56();

        int[][] intervals= {{1,4},{2,5},{4,6}};

        System.out.println(solution56.merge(intervals).toString());


    }






}
