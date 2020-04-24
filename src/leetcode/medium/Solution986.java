package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution986 {


    //Wrong, needs to be revisited. Bad algorithm.

    public static void main(String[] args) {
        Solution986 sol = new Solution986();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        sol.intervalIntersection(A, B);
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        class Intervals {

            int point;
            String type;

            public Intervals(int point, String type) {
                point = this.point;
                type = this.type;
            }
        }

        int i = 0, j = 0;
        boolean flag = true;

        List<int[]> results = new ArrayList<>();


        Intervals[] AIntervals = new Intervals[A.length * 2];
        Intervals[] BIntervals = new Intervals[B.length * 2];

        for (i = 0; i < A.length; i++) {
            if (flag) {
                AIntervals[j] = new Intervals(A[i][0], "start");
                flag = false;
            } else {
                AIntervals[j] = new Intervals(A[i][1], "end");
                flag = true;
            }
            j++;
        }

        flag = true;
        j = 0;

        for (i = 0; i < B.length; i++) {
            if (flag) {
                BIntervals[j] = new Intervals(B[i][0], "start");
                flag = false;
            } else {
                BIntervals[j] = new Intervals(B[i][1], "end");
                flag = true;
            }
            j++;
        }

        List<Intervals> intervals = new ArrayList<>();
        i = 0;
        j = 0;
        while (true) {

            if (i == AIntervals.length) {
                intervals.add(BIntervals[j]);
                j++;
            }

            if (j == BIntervals.length) {
                intervals.add(AIntervals[i]);
                i++;
            }

            if (i == AIntervals.length && j == BIntervals.length) {
                break;
            }

            if (AIntervals[i].point < BIntervals[j].point) {
                intervals.add(AIntervals[i]);
                i++;
            } else {
                intervals.add(BIntervals[j]);
                j++;
            }

        }
        i = 0;
        while (i < intervals.size() - 1) {

            String type = intervals.get(i).type;
            String type1 = intervals.get(i + 1).type;
            int point = intervals.get(i).point;
            int point1 = intervals.get(i + 1).point;


            if ((type.equals("start") && type1.equals("end")) || (type.equals("end") && type1.equals("start") && point == point1)) {
                int[] result = new int[2];
                result[0] = (intervals.get(i).point);
                result[1] = (intervals.get(i + 1).point);
                results.add(result);
            }
        }

        return (int[][]) results.toArray();

    }

}
