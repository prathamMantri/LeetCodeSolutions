package interview_questions_microsoft;

/***
 *
 * https://leetcode.com/discuss/interview-question/398056/
 *
 */

public class MaxInserts {
    public static void main(String[] args) {
        MaxInserts sol = new MaxInserts();
        System.out.println(sol.solution("aabab"));
        System.out.println(sol.solution("dog"));
        System.out.println(sol.solution("aa"));
        System.out.println(sol.solution("baaaa"));
        System.out.println(sol.solution("aaba"));
        System.out.println(sol.solution("aabaab"));
        System.out.println(sol.solution("aabaabaa"));
        System.out.println(sol.solution("aabaaabaa"));
        System.out.println(sol.solution("aabababaa"));
    }

    public int solution(String s) {
        int count = 2, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                if (count == -1) {
                    return -1;
                }
                count--;
            } else {
                res = count == 0 ? res : res + count;
                count = 2;
            }
        }
        return res + count;
    }


}
