package interview_questions_microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class UniqueFrequency {


    /****
     *
     *
     * https://leetcode.com/discuss/interview-question/398035/
     * @param s
     * @return
     */


    public int solution(String s) {

        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            while (n > 0) {
                if (!set.contains(n)) {
                    set.add(n);
                    break;
                } else {
                    count++;
                }
                n--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        UniqueFrequency sol = new UniqueFrequency();
        System.out.println(sol.solution("example"));
    }

}
