package leetcode.hard;

public class Solution1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int i_1 = 0, i_2 = 0, i_3 = 0, i = n - 1;
        while (i >= 0) {
            int ans = Integer.MIN_VALUE;
            ans = Math.max(ans, stoneValue[i] - i_1);
            if (i + 1 < n) ans = Math.max(ans, stoneValue[i] + stoneValue[i + 1] - i_2);
            if (i + 2 < n) ans = Math.max(ans, stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - i_3);
            i_3 = i_2;
            i_2 = i_1;
            i_1 = ans;
            i--;
        }
        if (i_1 > 0)
            return "Alice";
        if (i_1 == 0)
            return "Tie";

        return "Bob";

    }
}
