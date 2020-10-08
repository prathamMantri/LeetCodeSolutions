package leetcode.medium;

import java.util.TreeMap;

public class Solution729 {
    class MyCalendar {
        TreeMap<Integer, Integer> bookings;

        public MyCalendar() {
            bookings = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer prev = bookings.lowerKey(start);
            Integer next = bookings.higherKey(start);
            if ((prev == null || prev < start) && (next == null) || next >= start) {
                bookings.put(start, end);
                return true;
            } else {
                return false;
            }
        }
    }
}
