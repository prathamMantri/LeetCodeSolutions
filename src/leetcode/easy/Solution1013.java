package leetcode.easy;

public class Solution1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        return canNPartsEqualSum(A, 3);
    }

    private boolean canNPartsEqualSum(int[] A, int n) {
        if (A.length < n) {
            return false;
        }
        int sum = 0;
        for (int i : A) {
            sum = sum + i;
        }
        if (sum % n != 0) {
            return false;
        }
        int part = sum / n;
        int count = 0;
        sum = 0;
        int i = 0;
        while (i < A.length) {
            sum = sum + A[i];
            if (count == n - 1) {
                return true;
            }
            if (sum == part) {
                sum = 0;
                count++;
            }

            i++;
        }
        return false;
    }
}
