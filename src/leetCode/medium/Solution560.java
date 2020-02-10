package leetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public static void main(String[] args) {
        Solution560 sol = new Solution560();
        int[] a = {1, 2, 1, 3, 0, 5, -2};
        sol.subarraySum(a, 3);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k) || sum == k) {
                count = count + (map.get(sum - k) == null ? 1 : map.get(sum - k));
            }
            map.put(sum, map.get(sum) == null ? 1 : map.get(sum) + 1);
        }
        return count;
    }
}
