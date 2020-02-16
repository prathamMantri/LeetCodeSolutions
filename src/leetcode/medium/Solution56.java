package leetcode.medium;

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

            int minIndex=intervals[0][0];
            int maxIndex=intervals[0][1];

            int[][] results = new int[intervals.length][2];
            int count=0;

            for(int i=1; i<intervals.length; i++){
                if(maxIndex>intervals[i][0]){
                    minIndex = Math.min(minIndex, intervals[i][0]);
                    maxIndex = Math.max(maxIndex, intervals[i][1]);
                    results[count][0]=minIndex;
                    results[count][1]=maxIndex;
                }
            }
            return results;
    }

    public static void main(String[] args) {

        Solution56 solution56 = new Solution56();

        int[][] intervals= {{1,4},{2,5},{4,6}};

        System.out.println(solution56.merge(intervals).toString());


    }






}
