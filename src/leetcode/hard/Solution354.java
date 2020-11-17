package leetcode.hard;

import java.util.Arrays;

public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        int ans = 0;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        System.out.println(Arrays.deepToString(envelopes));
        int i = 0;
        int j = 1;

        while (j < envelopes.length) {
            if (envelopes[i][0] == envelopes[j][0] && envelopes[i][1] == envelopes[j][1]) {
                i++;
                j++;
            } else if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                j++;
                i++;
                ans++;
            } else {
                j++;
            }
        }
        return ans + 1;
    }
}
