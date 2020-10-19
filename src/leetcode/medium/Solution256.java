package leetcode.medium;

//Paint House
public class Solution256 {

    /**
     * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
     * <p>
     * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
     * Output: 10
     * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
     * Minimum cost: 2 + 5 + 3 = 10.
     * Example 2:
     * <p>
     * Input: costs = []
     * Output: 0
     * Example 3:
     * <p>
     * Input: costs = [[7,6,2]]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * costs.length == n
     * costs[i].length == 3
     * 0 <= n <= 100
     * 1 <= costs[i][j] <= 20
     *
     * @param costs
     * @return
     */

    public int minCost(int[][] costs) {
        print(costs);
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
            print(costs);
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }

    private void print(int[][] costs) {
        for (int[] cost : costs) {
            for (int c : cost) {
                System.out.print(c + "    ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
