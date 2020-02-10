package microsoftInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class StringWithout3Identical {

    public static void main(String[] args) {
        StringWithout3Identical sol = new StringWithout3Identical();
        System.out.println(sol.solution("xxxtxxx"));
    }

    /**
     * https://leetcode.com/discuss/interview-question/398039/
     */

    public String solution(String s) {


        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i <= s.length() - 3) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                list.add(i + 1);
            }
            i++;
        }
        StringBuilder str = new StringBuilder();
        for (i = 0; i < s.length(); i++) {
            if (!list.contains(i))
                str.append(s.charAt(i));
        }
        return str.toString();
    }

}
