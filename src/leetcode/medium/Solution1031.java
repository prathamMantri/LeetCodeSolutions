package leetcode.medium;

public class Solution1031 {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {

        int len = A.length;

        System.out.print("Input Array:   ");
        System.out.println();
        for (int value : A) {
            System.out.print(value + "  ");
        }

        // calculate the prefix sum from A[0] to A[i]
        int[] prefixSum = new int[len];
        prefixSum[0] = A[0];
        System.out.println("\nPrefix Sum: ");
        System.out.print(prefixSum[0] + "  ");
        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
            System.out.print(prefixSum[i] + "  ");
        }

        // calculate the suffix sum from A[i] to A[len-1]
        int[] suffixSum = new int[len];
        suffixSum[len - 1] = A[len - 1];
        System.out.println("\nSuffix Sum: ");
        System.out.print(suffixSum[len - 1] + "  ");
        for (int i = len - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + A[i];
            System.out.print(suffixSum[i] + "  ");
        }

        // L and M could be at left or right
        // so we need to calculate the both to get the max non-overlapping sum of entire array
        return Math.max(calculate(A, L, M, prefixSum, suffixSum), calculate(A, M, L, prefixSum, suffixSum));
    }

    private int calculate(int[] A, int L, int M, int[] prefixSum, int[] suffixSum) {
        int len = A.length;
        System.out.println();

        // calculate the maximum sum with length L with rightmost position at A[i], A[i] doesn't have to be included
        int[] leftSum = new int[len];
        leftSum[L - 1] = prefixSum[L - 1];
        System.out.println("\nLeft Sum: ");
        System.out.print(leftSum[L - 1] + "  ");
        for (int i = L; i < len; i++) {
            leftSum[i] = Math.max(leftSum[i - 1], prefixSum[i] - prefixSum[i - L]);
            System.out.print(leftSum[i] + "  ");
        }

        // calcualte the maxisum sum with length M with leftmost position at A[i], A[i] doesn't have to be included
        int[] rightSum = new int[len];
        rightSum[len - M] = suffixSum[len - M];
        System.out.println("\nRight Sum: ");
        System.out.print(rightSum[L - 1] + "  ");
        for (int i = len - M - 1; i >= 0; i--) {
            rightSum[i] = Math.max(rightSum[i + 1], suffixSum[i] - suffixSum[i + M]);
            System.out.print(rightSum[i] + "  ");
        }

        // now we have all the data for max sum with length L from the left
        // and max sum with length M from the right
        // just iterate and add them up to find the max non-overlapping sum
        // note the i+1 index is for non-overlapping

        int res = Integer.MIN_VALUE;
        System.out.println();
        System.out.println("\nFinding Max Result: ");
        for (int i = L - 1; i <= len - M - 1; i++) {
            int sum = leftSum[i] + rightSum[i + 1];
            System.out.println("i is " + i + "   res will be between  " + sum + " and " + res);
            res = Math.max(sum, res);
        }
        return res;

    }
}
