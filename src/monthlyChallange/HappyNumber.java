package monthlyChallange;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber sol = new HappyNumber();
        System.out.println(sol.isHappy(35));
    }

    public boolean isHappy(int n) {
        Set<Integer> memory = new HashSet<Integer>();
        return n == 1 || getHappyNumber(n, memory);
    }

    public boolean getHappyNumber(int n, Set<Integer> memory) {
        int sum = 0, digit;
        while (n != 0) {
            digit = n % 10;
            n = n / 10;
            sum = sum + (digit * digit);
        }

        return !memory.contains(sum) && (sum == 1 || getHappyNumber(sum, memory));

    }

}
