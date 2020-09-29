package leetcode.medium;

public class Solution357 {

    /**
     * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
     * <p>
     * Example:
     * <p>
     * Input: 2
     * Output: 91
     * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
     * excluding 11,22,33,44,55,66,77,88,99
     * <p>
     * Constraints:
     * <p>
     * 0 <= n <= 8
     */

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int ans = 10, base = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            base = base * (9 - i + 2);
            ans += base;
        }
        return ans;
    }
    /*

    int res;
    Set<Integer> set;

    public int countNumbersWithUniqueDigits(int n) {
        res = 10;
        int limit = (int)Math.pow(10, n);
        System.out.println(limit);
        for(int i = 10; i < limit ; i++){
            if(isUnique(i)){
                res++;
            }
        }
        return res;
    }

    boolean isUnique(int n){
        set = new HashSet<>();
        while(n>0){
            if(set.contains(n % 10)) {
                return false;
            }
            set.add(n%10);
            n = n / 10;
        }
        return true;
    }
    */
    /* public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 10;
        }
        Set<Integer> set = new HashSet<>();
        helper(set, n);
        return res+1;
    }

    void helper(Set<Integer> set, int n){
        if(set.size() >= n){
            return;
        }
        for(int i=0; i<=9; i++){
            if(set.size()==0 && i==0) continue;
            if(set.contains(i)) continue;
            set.add(i);
            res++;
            helper(set, n);
            set.remove(i);
        }
    }
    */
    /*public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        if (n == 1) return 10;
        int prev2 = 10;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {

            int output = prev2 + (prev2 - prev1) * (11 - i);
            prev1 = prev2;
            prev2 = output;
        }
        return prev2;
    }
*/
}
