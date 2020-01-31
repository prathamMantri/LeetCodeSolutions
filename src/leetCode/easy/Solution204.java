package leetCode.easy;

public class Solution204 {

    public static void main(String[] args) {
        Solution204 sol = new Solution204();
        sol.countPrimes(10);
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 3; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


}
