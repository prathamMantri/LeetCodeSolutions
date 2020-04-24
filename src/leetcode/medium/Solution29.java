package leetcode.medium;

public class Solution29 {
    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     * <p>
     * Return the quotient after dividing dividend by divisor.
     * <p>
     * The integer division should truncate toward zero.
     * <p>
     * Example 1:
     * <p>
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Example 2:
     * <p>
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Note:
     * <p>
     * Both dividend and divisor will be 32-bit signed integers.
     * The divisor will never be 0.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
     *
     * @param dividend
     * @param divisor
     * @return
     */


    public int divide(int dividend, int divisor) {

        int count = 0;

        int calcDividend = dividend;

        if (dividend == 0 || Math.abs(dividend) < Math.abs(divisor))
            return 0;
        if (dividend == divisor)
            return 1;

        while (true) {
            dividend = Math.abs(dividend) - Math.abs(divisor);
            if (calcDividend < 0 && divisor < 0)
                count++;
            else if (calcDividend < 0 || divisor < 0)
                count--;
            else
                count++;
            if (Math.abs(dividend) < Math.abs(divisor))
                break;
        }

        return count;
    }
}
