package leetcode.hard;

import java.util.TreeMap;

public class Solution715 {

    public static class RangeModule {

        TreeMap<Integer, Boolean> map;

        public RangeModule() {
            map = new TreeMap<>();
            map.put(0, false);
        }

        public void addRange(int left, int right) {

            int lowerKey = map.lowerKey(left); //  greatest key strictly less than the given key
            int floorKey = map.floorKey(right); //  greatest key less than or equal to the given key

            System.out.println(lowerKey);
            System.out.println(floorKey);


            boolean from = map.get(lowerKey);// if it is available then from becomes true , if not (meaning there is no such key which is strictly less than give key) its false
            System.out.println("is \"from\" Available for left value " + left + "====>" + from);
            boolean to = map.get(floorKey); //
            System.out.println("is \"to\" Available for right value " + right + "====>" + to);

            map.subMap(left, true, right, true).clear();

            System.out.println("Map from " + left + " to " + right + " got cleared");

            if (!from) map.put(left, true);
            if (!to) map.put(right, false);
        }

        public boolean queryRange(int left, int right) {
            int lower = map.lowerKey(right);
            return lower <= left && map.get(lower);
        }

        public void removeRange(int left, int right) {

            int lowerKey = map.lowerKey(left);
            int floorKey = map.floorKey(right);

            boolean from = map.get(lowerKey);
            boolean to = map.get(floorKey);

            map.subMap(left, true, right, true).clear();

            if (from) map.put(left, false);
            if (to) map.put(right, true);
        }

    }



    /*
    TreeMap<Integer, Integer> intervals = new TreeMap<>();
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);
        if (start != null && intervals.get(start) >= left) {
            left = start;
        }
        if (end != null && intervals.get(end) > right) {
            right = intervals.get(end);
        }
        intervals.put(left, right);

        intervals.subMap(left, false, right, true).clear();
    }
    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if (start == null) return false;
        return intervals.get(start) >= right;
    }
    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if (end != null && intervals.get(end) > right) {
            intervals.put(right, intervals.get(end));
        }
        if (start != null && intervals.get(start) > left) {
            intervals.put(start, left);
        }
        intervals.subMap(left, true, right, false).clear();
    }
    */
}
