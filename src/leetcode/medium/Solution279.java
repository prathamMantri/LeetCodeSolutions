package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution279 {
    public int numSquares(int n) {
        //return numSquaresBFS(n);
        return numSquaresDP(n);
    }

    private int numSquaresDP(int n) {
         /*
         dp[0] = 0;
         dp[1] = 1;
         dp[2] = 2;
         dp[3] = 3;
         dp[4] = Min(dp[4 - 1*1] + 1, dp[4 - 2*2] + 1) = 1
         dp[5] = Min(dp[5 - 1*1] + 1, dp[5 - 2*2] + 1) = 2
         .
         .
         .
         .
         .
         dp[13] = Min(dp[13 - 1*1] + 1, dp[13 - 2*2] + 1, dp[13 - 3*3] + 1)
                = Min(dp[12]+1, dp[9] + 1, dp[4] + 1)
                = 2
         .
         .
         .
         .
         .
         dp[n] = Min(dp[n - i*i] + 1) where n >= i*i >=0 && i>=1

         */
        // 22 MS
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }


    // 9 MS
    private int numSquaresBFS(int n) {
        int sqrt = (int) Math.sqrt(n);
        int level = 0;
        boolean[] visited = new boolean[n];
        int[] perfectSquares = new int[sqrt + 1];
        for (int i = 0; i < sqrt + 1; i++) {
            perfectSquares[i] = i * i;
        }
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(n);
        while (!qu.isEmpty()) {
            level++;
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int num = qu.poll();
                for (int pSquare : perfectSquares) {
                    int remain = num - pSquare;
                    if (remain == 0)
                        return level;
                    if (remain > 0 && !visited[remain - 1]) {
                        visited[remain - 1] = true;
                        qu.offer(remain);
                    } else if (remain < 0)
                        break;
                }
            }
        }
        return 0;
    }
}
