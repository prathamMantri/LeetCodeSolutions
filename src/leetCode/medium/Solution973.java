package leetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution973 {

    public static void main(String[] args) {

        //int[][] input = {{1,3},{-2,2}};
        int[][] input = {{0, 1}, {1, 0}};
        //int[][] input = {{3,3},{5,-1},{-2,4}};

        Solution973 sol = new Solution973();
        sol.kClosest(input, 1);


    }

    /****
     *
     *
     * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
     *
     * (Here, the distance between two points on a plane is the Euclidean distance.)
     *
     * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
     *
     *
     *
     * Example 1:
     *
     * Input: points = [[1,3],[-2,2]], K = 1
     * Output: [[-2,2]]
     * Explanation:
     * The distance between (1, 3) and the origin is sqrt(10).
     * The distance between (-2, 2) and the origin is sqrt(8).
     * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
     * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
     * Example 2:
     *
     * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
     * Output: [[3,3],[-2,4]]
     * (The answer [[-2,4],[3,3]] would also be accepted.)
     *
     *
     * Note:
     *
     * 1 <= K <= points.length <= 10000
     * -10000 < points[i][0] < 10000
     * -10000 < points[i][1] < 10000
     *
     *
     *
     *
     * @param points
     * @param K
     * @return
     */


    public int[][] kClosest(int[][] points, int K) {

        Map<Double, List<Integer>> countMap = new TreeMap<>();
        int[][] result = new int[K][2];

        for (int i = 0; i < points.length; i++) {
            Double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            List<Integer> coordinates = new ArrayList<>();
            coordinates.add(points[i][0]);
            coordinates.add(points[i][1]);
            countMap.put(distance, coordinates);
        }

        int count = 0;
        for (Map.Entry<Double, List<Integer>> entry : countMap.entrySet()) {
            if (K == count) {
                return result;
            }
            result[count][0] = entry.getValue().get(0);
            result[count][1] = entry.getValue().get(1);
            count++;
        }

        return result;
    }

}
