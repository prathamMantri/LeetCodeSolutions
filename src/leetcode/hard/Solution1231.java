package leetcode.hard;

public class Solution1231 {
    public int maximizeSweetness(int[] sweetness, int K) {
        if (sweetness == null && sweetness.length == 0) {
            return 0;
        }
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int num : sweetness) {
            total = total + num;
            min = Math.min(num, min);
        }
        int lo = min;
        int hi = total;
        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2) + 1;
            if (isPossible(mid, sweetness, K))
                hi = mid - 1;
            else
                lo = mid;
        }
        return lo;
    }

    private boolean isPossible(int max, int[] sweetness, int K) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < sweetness.length; i++) {
            if (count > K) {
                return false;
            }
            sum = sum + sweetness[i];
            if (sum >= max) {
                count++;
                sum = 0;
            }
        }
        return count <= K;
    }
}
