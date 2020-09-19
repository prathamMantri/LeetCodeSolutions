package interview_questions_microsoft;

import java.util.Stack;

public class MaxPossibleValue {

    public static void main(String[] args) {
        MaxPossibleValue sol = new MaxPossibleValue();
        System.out.println(sol.solution(5556));
        System.out.println(sol.solution(670));
        System.out.println(sol.solution(0));
        System.out.println(sol.solution(-999));
    }

    /***
     *
     *https://leetcode.com/discuss/interview-question/398050/
     *
     * Adding 5
     *
     */

    public int solution(int num) {
        Stack<Integer> stack = new Stack<>();
        if (num == 0) {
            return 50;
        }
        boolean negative = num < 0;
        while (num != 0) {
            stack.push(num % 10);
            num = num / 10;
        }
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            if (flag) {
                if (digit < 5) {
                    res.append("5");
                    flag = false;
                }
            }
            res.append(Math.abs(digit));
        }
        if (flag) {
            res.insert(0, 5);
        }
        return negative ? (-1 * Integer.parseInt(res.toString())) : Integer.parseInt(res.toString());
    }


}
