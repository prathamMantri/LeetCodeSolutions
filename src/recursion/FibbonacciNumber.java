package recursion;

public class FibbonacciNumber {
    public static void main(String[] args) {
        FibbonacciNumber sol = new FibbonacciNumber();
        System.out.println(sol.fib(5));
    }

    public int fib(int N) {
        int[] fib = new int[N + 1];

        if (N > 1) {
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i < fib.length; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[N];
        } else {
            return N;
        }
    }


}
