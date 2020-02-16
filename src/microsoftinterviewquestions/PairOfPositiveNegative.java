package microsoftinterviewquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/406031/
 */

public class PairOfPositiveNegative {

    public static void main(String[] args) {

        PairOfPositiveNegative sol = new PairOfPositiveNegative();
        int[] input = {3, 2, -2, 5, -3};
        int[] input2 = {1, 2, 3, -4};
        System.out.println(sol.solution(input));
        System.out.println(sol.solution(input2));


    }

    public int solution(int[] input) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            list.add(input[i]);
        }

        for (int i = 0; i < input.length; i++) {
            if (list.contains(input[i] * (-1))) {
                max = Math.abs(input[i]) > max ? Math.abs(input[i]) : max;
            }
        }
        return max;

    }
}
