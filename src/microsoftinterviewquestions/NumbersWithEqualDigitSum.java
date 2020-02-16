package microsoftinterviewquestions;


import java.util.Map;
import java.util.TreeMap;

/****
 *
 * https://leetcode.com/discuss/interview-question/365872/
 * Not yet done
 *
 */

public class NumbersWithEqualDigitSum {

    public static void main(String[] args) {
        NumbersWithEqualDigitSum sol = new NumbersWithEqualDigitSum();
        System.out.println(sol.digitSum(678));
    }

    public int solution(int[] nums) {

        // [51, 17, 71, 42]

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {

            int digitSum = digitSum(nums[i]);

            if (map.containsKey(digitSum)) {

            }


        }
        return 0;
    }

    public int digitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }
}
