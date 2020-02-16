package leetcode.medium;

public class Solution50 {
    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        System.out.println(solution50.myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {
        double result = 1;

        int N = Math.abs(n);

        for (int i = 0; i < N; i++) {
            if (n == 0) {
                return result;
            }
            if (n > 0) {
                result = result * x;
            } else {
                result = result / x;
            }
        }
        return result;
    }

}
