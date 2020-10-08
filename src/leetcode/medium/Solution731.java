package leetcode.medium;

import java.util.TreeMap;

public class Solution731 {
    static class MyCalendarTwo {


        TreeMap<Integer, Integer> room1;
        TreeMap<Integer, Integer> room2;

        public MyCalendarTwo() {
            room1 = new TreeMap<>();
            room2 = new TreeMap<>();
        }

        public boolean book(int start, int end) {

            Integer prev1 = room1.floorKey(start);
            Integer next1 = room1.ceilingKey(start);
            Integer prev2 = room2.floorKey(start);
            Integer next2 = room2.ceilingKey(start);

            if ((prev1 == null || room1.get(prev1) <= start) && (next1 == null || end <= next1)) {
                room1.put(start, end);
                return true;
            } else if ((prev2 == null || room2.get(prev2) <= start) && (next2 == null || end <= next2)) {
                room2.put(start, end);
                return true;
            } else {
                return false;
            }
        }
    }
}
/*
room 1      10      50      5
            20      60      10
            \

room 2      10
            40



 */
