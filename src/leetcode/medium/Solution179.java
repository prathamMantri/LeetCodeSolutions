package leetcode.medium;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution179 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        Solution179 sol = new Solution179();
        sol.largestNumber(nums);
    }

    public String largestNumber(int[] nums) {
        Map<String, Integer> numsMap = new TreeMap<>(Comparator.reverseOrder());
        StringBuilder res = new StringBuilder();
        for (int num : nums) {
            numsMap.put(String.valueOf(num), numsMap.getOrDefault(String.valueOf(num), 0) + 1);
        }
        for (String st : numsMap.keySet())
            res.append(st);
        return res.toString();
    }
}
