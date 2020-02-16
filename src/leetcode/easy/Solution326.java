package leetcode.easy;

public class Solution326 {
    public boolean isPowerOfThree(int n) {
        return n == 1 || (n >= 3 && n % 3 == 0) && (n / 3 == 1 || isPowerOfThree(n / 3));
    }
    public static void main(String[] args){
        Solution326 sol = new Solution326();
      //  sol.isPowerOfThree(1);
        System.out.println(sol.isPowerOfThree(1));
    }
}
