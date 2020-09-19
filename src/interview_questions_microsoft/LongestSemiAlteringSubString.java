package interview_questions_microsoft;

public class LongestSemiAlteringSubString {


    public static void main(String[] args) {
        LongestSemiAlteringSubString sol = new LongestSemiAlteringSubString();
        System.out.println(sol.solution("baaa"));
        System.out.println(sol.solution("baaabb"));
        System.out.println(sol.solution("baaabbabbb"));
    }

    /**
     * https://leetcode.com/discuss/interview-question/398037/
     */

    public int solution(String s) {

        int max = 0, current = 0, i = 0, j = 0;
        int count = 0;


        while (j < s.length() - 1 && i < s.length() - 1) {
            if (count == 1) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    i = j;
                    j--;
                    current = current + count;
                    max = Math.max(current, max);
                    count = 0;
                    current = 0;
                } else {
                    count = 0;
                    current++;
                }
            } else {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                }
                current++;
            }
            j++;
        }


        return Math.max(max, current);
    }


}
