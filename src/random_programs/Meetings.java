package random_programs;
/**
 * We are writing a tool to help users manage their calendars. Given an unordered list of times of day when someone is busy, write a function that tells us whether they're available during a specified period of time.
 * <p>
 * Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).
 * <p>
 * Sample input:
 * <p>
 * meetings = [
 * [1230, 1300], // 12:30 PM to 1:00 PM
 * [845, 900],   //  8:45 AM to 9:00 AM
 * [1300, 1500]  //  1:00 PM to 3:00 PM
 * ]
 * <p>
 * Expected output:
 * <p>
 * isAvailable(meetings, 915, 1215)   => true
 * isAvailable(meetings, 900, 1230)   => true
 * isAvailable(meetings, 850, 1240)   => false
 * isAvailable(meetings, 1200, 1300)  => false
 * isAvailable(meetings, 700, 1600)   => false
 * isAvailable(meetings, 800, 845)    => true
 * isAvailable(meetings, 1500, 1800)  => true
 * isAvailable(meetings, 845, 859)    => false
 * isAvailable(meetings, 846, 900)    => false
 * isAvailable(meetings, 846, 859)    => false
 * isAvailable(meetings, 845, 900)    => false
 * isAvailable(meetings, 2359, 2400)  => true
 * isAvailable(meetings, 930, 1600)   => false
 * isAvailable(meetings, 800, 850)    => false
 * isAvailable(meetings, 1400, 1600)  => false
 * isAvailable(meetings, 1300, 1501)  => false
 * <p>
 * n = number of meetings
 * r = minutes in range of meetings
 */

import java.util.Arrays;

public class Meetings {
    public static void main(String[] argv) {
        int[][] meetings = {{1230, 1300}, {845, 900}, {1300, 1500}};
        int[][] input = {
                {915, 1215},
                {900, 1230},
                {850, 1240},
                {1200, 1300},
                {700, 1600},
                {800, 845},
                {1500, 1800},
                {845, 859},
                {846, 900},
                {846, 859},
                {845, 900},
                {2359, 2400},
                {930, 1600},
                {800, 850},
                {1400, 1600},
                {1300, 1501},
        };
        Meetings sol = new Meetings();
        for (int[] ints : input)
            System.out.println("isAvailable(meetings, " + ints[0] + "," + ints[1] + ")   => " + sol.isAvailable(meetings, ints[0], ints[1]));
    }

    boolean isAvailable(int[][] meetings, int startTime, int endTime) {
        if (meetings == null || meetings.length == 0) {
            return true;
        }
        boolean isAvailable = true;
        Arrays.sort(meetings, (a, b) -> a[0] / 100 == b[0] / 100 ? a[1] % 100 - b[1] % 100 : a[0] / 100 - b[0] / 100);
        if (startTime > meetings[meetings.length - 1][1])
            return true;
        if (endTime < meetings[0][0])
            return true;
        for (int[] meeting : meetings) {
            if (startTime == meeting[0])
                return false;
            else if (startTime < meeting[0] && endTime > meeting[0])
                return false;
            else if (startTime > meeting[0] && startTime < meeting[1])
                return false;
        }
        return isAvailable;
    }
}

