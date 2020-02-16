package microsoftinterviewquestions;

public class MinimumMoves {

    public static void main(String[] args) {
        MinimumMoves solution = new MinimumMoves();
        System.out.println(solution.solution("baaaaa"));

        System.out.println(solution.solution("baaabbaabbba"));

        System.out.println(solution.solution("baabab"));
    }

    /***
     *
     * https://leetcode.com/discuss/interview-question/398026/
     * Important
     *
     */

    public int solution(String s) {
        int count = 0;
        int i = 0;
        while (i < s.length() - 3) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                count++;
                i = i + 2;
            }
            i++;
        }
        return count;
    }


}
