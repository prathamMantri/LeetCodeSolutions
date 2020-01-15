package leetCode.easy;

public class Solution231 {
    public static void main(String[] args) {
        Solution231 solution231 = new Solution231();
        solution231.isPowerOfTwo(134);
    }

    public boolean isPowerOfTwo(int n) {
        return n != 0 && (n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2)));
    }
}
