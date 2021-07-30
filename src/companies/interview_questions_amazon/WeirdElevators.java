package companies.interview_questions_amazon;

import java.util.ArrayList;
import java.util.List;

public class WeirdElevators {

    static boolean isPrime(int n) {
        for (int i = 3; i < Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static int GCD(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        if (a > b)
            return GCD(a - b, b);
        return GCD(a, b - a);
    }

    public String findTime(int N, int x, int y, int m) {

        List<Integer> primeNumberList = new ArrayList<>();
        primeNumberList.add(2);

        for (int i = 3; i <= 1000000; i = i + 2)
            if (isPrime(i))
                primeNumberList.add(i);


        while (N != 0) {

            int gcd = GCD(x, y);
            int t = 0;
            int xFactor = x / gcd;
            int yFactor = y / gcd;


            for (int i = 0; i < m; i++) {
                int prime = primeNumberList.get(i);

                if (prime >= m)
                    break;

                while (xFactor % prime == 0) {
                    xFactor = xFactor / prime;
                    t++;
                }
                while (yFactor % prime == 0) {
                    yFactor = yFactor / prime;
                    t++;
                }

                if (xFactor == 1 && yFactor == 1) {
                    break;
                }
            }
            if (xFactor == 1 && yFactor == 1) return xFactor + " " + yFactor;
        }
        return "-1";
    }

}
