package leetcode.easy;

public class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        Solution88 sol = new Solution88();
        sol.merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] A, int m, int[] B, int n) {

        while (n > 0) {
            A[m + n - 1] = (m == 0 || B[n - 1] > A[m - 1]) ? B[--n] : A[--m];
        }
        System.out.println(A);
    }
}
