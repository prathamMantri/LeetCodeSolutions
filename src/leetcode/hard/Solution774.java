package leetcode.hard;

public class Solution774 {
    public double minmaxGasDist(int[] stations, int K) {
        double hi = 0;
        double lo = 0;
        for (int i = 1; i < stations.length; i++) {
            hi = Math.max(hi, stations[i] - stations[i - 1]);
        }
        double ans = 0;
        while (hi - lo >= 1e-6) {
            double mid = lo + (hi - lo) / 2;
            if (canFitAtLeastKGasStation(stations, mid, K)) {
                ans = mid;
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return ans;
    }

    public boolean canFitAtLeastKGasStation(int[] stations, double mid, int K) {
        int count = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            count = count + (int) (Math.ceil((stations[i + 1] - stations[i]) / mid)) - 1;
        }
        return count <= K;
    }
}
