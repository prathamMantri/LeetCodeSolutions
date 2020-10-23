package leetcode.medium;

import java.util.PriorityQueue;

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
     * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
     *
     * (Here, the distance between two points on a plane is the Euclidean distance.)
     *
     * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
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
     * Note:
     *
     * 1 <= K <= points.length <= 10000
     * -10000 < points[i][0] < 10000
     * -10000 < points[i][1] < 10000
     *
     * @param points
     * @param K
     * @return
     */

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Distance> queue = new PriorityQueue<Distance>((a, b) -> (b.getDistance() - a.getDistance()));
        int[][] result = new int[K][2];

        if (K == points.length) {
            return points;
        }
        Distance d;
        for (int i = 0; i < points.length; i++) {

            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            int[] coordinates = new int[2];

            coordinates[0] = points[i][0];
            coordinates[1] = points[i][1];

            d = new Distance(coordinates, distance);
            queue.offer(d);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            result[i++] = queue.poll().getCoordinates();
            K--;
        }
        return result;
    }

    class Distance {
        int[] coordinates;
        int distance;

        public Distance(int[] coordinates, int distance) {
            this.coordinates = coordinates;
            this.distance = distance;
        }

        int getDistance() {
            return distance;
        }

        int[] getCoordinates() {
            return coordinates;
        }
    }
}
