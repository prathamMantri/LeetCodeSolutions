package companies.interview_questions_microsoft;

public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring sol = new LongestSubstring();
        System.out.print(sol.solution("baabbaabb"));
    }

    /**
     * https://leetcode.com/discuss/interview-question/398031/
     * <p>
     * Given a string s containing only a and b, find longest substring of s such that s does not contain more than two contiguous occurrences of a and b.
     * <p>
     * Example 1:
     * Input: "aabbaaaaabb"
     * Output: "aabbaa"
     * <p>
     * Example 2:
     * Input: "aabbaabbaabbaa"
     * Output: "aabbaabbaabbaa"
     *
     * Important
     *
     */

    public String solution(String s) {
        int j = 0;
        String currentRes = "";
        String mainResult = "";
        boolean flag = false;
        while (j < s.length() - 1) {
            if (!flag) {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    flag = true;
                    currentRes = currentRes + s.charAt(j) + s.charAt(j + 1);
                } else {
                    mainResult = (mainResult.length() > currentRes.length()) ? mainResult : currentRes;
                    currentRes = "";
                    flag = false;
                }
            } else {
                if (s.charAt(j) == s.charAt(j + 1)) {
                    mainResult = (mainResult.length() > currentRes.length()) ? mainResult : currentRes;
                    currentRes = "";
                    flag = true;
                } else {
                    flag = false;
                }
            }
            j++;
        }
        return (mainResult.length() > currentRes.length()) ? mainResult : currentRes;
    }


}
