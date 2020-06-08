package dynamicprogramming;

import java.util.Arrays;

public class CoinChangeProblem {

    /**
     *
     * Question: Given an input amount of change x, write a function to determine the
     * minimum number of coins required to make that amount of change.
     * ● Eg. (using American coins)
     * change(1) = 1
     * change(3) = 3
     * change(7) = 3
     * change(32) = 4
     *
     * Solution Step:
     *
     *
     * Step 1: Create an array called cache of size of given number and initialize to -1.
     * Step 2: Pass that array in the another function which will do actual calculations.
     * **********************Actual calculation************************/
    public static void main(String[] args) {

        int x = 10;
        int[] coins = {1, 2, 5};

        CoinChangeProblem cc = new CoinChangeProblem();
        System.out.println(cc.change(x, coins));

    }

    /**
     * Step 1: First define the base case to stop the function.
     * Step 2: Set min to the given number.
     * Step 3: Do a loop on given coins to check if the given number is greater than the coins available
     * Step 4: If the difference between coin and number is greater than 0, means we can take that coin into consideration.
     * Step 5: Check the difference is already being calculated using cache.
     * Step 6: Calculate the number of coin using recursive call by passing remaining difference
     * Step 7: Store the already calculated value in cache.
     * Step 8: Store min using if its greater than value + 1 then store min as value +1
     */


    public int change(int x, int[] coins) {
        int[] cache = new int[x];
        Arrays.fill(cache, -1);
        return change(x, coins, cache);
    }

    private int change(int x, int[] coins, int[] cache) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        int min = x;
        for (int coin : coins) {
            if (x - coin >= 0) {
                int c;
                if (cache[x - coin] >= 0) {
                    c = cache[x - coin];
                } else {
                    c = change(x - coin, coins, cache);
                    cache[x - coin] = c;
                }
                min = Math.min(min, c + 1);
            }
        }
        return min;
    }


}
