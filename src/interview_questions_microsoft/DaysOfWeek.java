package interview_questions_microsoft;

import java.util.HashMap;
import java.util.Map;

public class DaysOfWeek {

    /***
     *
     * https://leetcode.com/discuss/interview-question/398047/
     */


    public String getDayOfWeek(String day, int n) {
        Map<String, Integer> days = new HashMap<>();

        String[] week = {"Mon", "Tue", "Wed", "Thus", "Fri", "Sat", "Sun"};

        for (int i = 0; i < week.length; i++) {
            days.put(week[i], i);
        }
        return week[days.get(day) + n % 7];

    }

}
