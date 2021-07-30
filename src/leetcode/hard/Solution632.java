package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution632 {
    public static void main(String[] args) {

        List<List<Integer>> tests = new ArrayList<>();
        List<Integer> test = new ArrayList<>();

        test.add(4);
        test.add(10);
        test.add(15);
        test.add(24);
        test.add(26);
        tests.add(new ArrayList<>(test));
        test.clear();

        test.add(0);
        test.add(9);
        test.add(12);
        test.add(20);
        tests.add(new ArrayList<>(test));
        test.clear();

        test.add(5);
        test.add(18);
        test.add(22);
        test.add(30);
        tests.add(new ArrayList<>(test));
        test.clear();

        Solution632 sol = new Solution632();
        sol.smallestRange(tests);


    }

    public int[] smallestRange(List<List<Integer>> nums) {
        // Keep index of every element
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        for (int i = 0; i < nums.size(); i++) {
            for (int n : nums.get(i)) {
                if (!map.containsKey(n)) map.put(n, new ArrayList<>());
                map.get(n).add(i);
            }
        }

        // Create a sorted array
        List<Integer> list = new ArrayList(map.keySet());

        // Sliding window
        int l = 0, r = 0;
        int[] ans = new int[]{list.get(0), list.get(list.size() - 1)};
        int[] cnt = new int[nums.size()];
        while (l < list.size()) {
            // Move right pointer
            while (r < list.size() && !allIn(cnt)) {
                for (int m : map.get(list.get(r))) cnt[m]++;
                r++;
            }
            // Condition match
            if (allIn(cnt) && (list.get(r - 1) - list.get(l)) < (ans[1] - ans[0])) {
                ans = new int[]{list.get(l), list.get(r - 1)};
            }
            // Move left pointer
            for (int m : map.get(list.get(l))) cnt[m]--;
            l++;
        }
        return ans;
    }

    private boolean allIn(int[] cnt) {
        for (int c : cnt) {
            if (c == 0) return false;
        }
        return true;
    }


}
