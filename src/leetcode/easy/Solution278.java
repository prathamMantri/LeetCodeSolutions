package leetcode.easy;

public class Solution278 {
    public static void main(String[] args) {
        Solution278 sol = new Solution278();
        System.out.println(sol.firstBadVersion(7));
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else
                right = mid;
        }

        return left;

    }

    Boolean isBadVersion(int n) {
        return n > 2;
    }

}
