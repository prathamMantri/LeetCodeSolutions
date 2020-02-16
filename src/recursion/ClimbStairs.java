package recursion;

public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs sol = new ClimbStairs();
        System.out.println(sol.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        return memoize(2, ways, n);
    }

    public int memoize(int currentStep, int[] ways, int top) {
        ways[currentStep] = ways[currentStep - 2] + ways[currentStep - 1];
        if (currentStep == top - 1) {
            return ways[currentStep];
        }
        return memoize(++currentStep, ways, top);
    }
}
