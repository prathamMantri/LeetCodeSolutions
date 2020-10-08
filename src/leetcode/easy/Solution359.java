package leetcode.easy;
import java.util.HashMap;
import java.util.Map;
public class Solution359 {
    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(0, "A"));
        System.out.println(logger.shouldPrintMessage(0, "B"));
        System.out.println(logger.shouldPrintMessage(0, "C"));
        System.out.println(logger.shouldPrintMessage(0, "A"));
        System.out.println(logger.shouldPrintMessage(0, "B"));
        System.out.println(logger.shouldPrintMessage(0, "C"));
        System.out.println(logger.shouldPrintMessage(11, "A"));
        System.out.println(logger.shouldPrintMessage(11, "B"));
        System.out.println(logger.shouldPrintMessage(11, "C"));
        System.out.println(logger.shouldPrintMessage(11, "A"));
    }
    static class Logger {
        Map<String, Integer> map;
        /**
         * Initialize your data structure here.
         */
        public Logger() {
            map = new HashMap<>();
        }
        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer oldTimestamp = map.get(message);
            map.put(message, oldTimestamp == null || timestamp - oldTimestamp > 9 ? timestamp : oldTimestamp);
            return oldTimestamp == null || timestamp - oldTimestamp >= 10;
        }
    }
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
}
