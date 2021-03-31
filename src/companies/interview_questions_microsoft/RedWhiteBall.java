package companies.interview_questions_microsoft;


/**
 * https://leetcode.com/discuss/interview-question/414660/
 * <p>
 * WRONG
 */

public class RedWhiteBall {
    public static void main(String[] args) {
        RedWhiteBall sol = new RedWhiteBall();
        System.out.println(sol.solution("RRRWRR"));
        System.out.println(sol.solution("WRRWWR"));
        System.out.println(sol.solution("WWRWWWRWR"));
        System.out.println(sol.solution("WWW"));
        System.out.println(sol.solution("RRRWWWRRW"));
        System.out.println(sol.solution("RRRRR"));
        System.out.println(sol.solution("RWWWR"));

       /* solution("RRRWRR"); // 2
        solution("WRRWWR"); // 2
        solution("WWRWWWRWR"); // 4
        solution("WWW") ; // 0
        solution("RRRWWWRRW"); // 6
        solution("RRRRR"); // 0
        solution("RWWWR"); // 3*/

    }

    public int solution(String s) {
        int wCount = 0;
        int rCount = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (!flag) {
                if (s.charAt(i) == 'R') {
                    flag = true;
                }
            } else {
                if (s.charAt(i) == 'W') {
                    wCount++;
                } else {
                    rCount++;
                }
            }
        }
        return rCount > 0 ? wCount + rCount : 0;
    }

}
