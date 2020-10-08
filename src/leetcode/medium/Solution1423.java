package leetcode.medium;

public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum = sum + cardPoints[i];
        if (k >= cardPoints.length) {
            return sum;
        }
        int max = sum;
        for (int i = 1; i <= k; i++) {
            sum = sum + cardPoints[cardPoints.length - i] - cardPoints[k - i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
