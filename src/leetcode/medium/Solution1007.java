package leetcode.medium;

public class Solution1007 {
    public int minDominoRotations(int[] A, int[] B) {

        int a = A[0];
        int b = B[0];
        int resA = 0;
        int resB = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != a && B[i] == a)
                resA++;
            else if (A[i] != a)
                resA = A.length;
        }
        for (int i = 1; i < B.length; i++) {
            if (B[i] != a && A[i] == a)
                resB++;
            else if (B[i] != a)
                resB = B.length;
        }
        return Math.min(resA, resB);
    }
}
