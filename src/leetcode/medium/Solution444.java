package leetcode.medium;

import java.util.List;

public class Solution444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (seqs == null || seqs.size() == 0) {
            return false;
        }
        int orgLen = org.length;
        int[] idx = new int[orgLen + 1];
        boolean[] pairs = new boolean[orgLen];

        for (int i = 0; i < orgLen; i++) {
            idx[org[i]] = i;
        }

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                if (seq.get(i) > orgLen || seq.get(i) < 0) {
                    return false;
                }
                if (i > 0 && idx[seq.get(i - 1)] >= idx[seq.get(i)]) {
                    return false;
                }
                if (i > 0 && idx[seq.get(i - 1)] + 1 == idx[seq.get(i)]) {
                    pairs[idx[seq.get(i - 1)]] = true;
                }
            }
        }
        for (int i = 0; i < orgLen - 1; i++) {
            if (!pairs[i]) {
                return false;
            }
        }
        return true;
    }
}
