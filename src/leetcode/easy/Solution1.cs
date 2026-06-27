// https://leetcode.com/problems/two-sum/description/

public class Solution1 {
    public int[] TwoSum(int[] nums, int target) {
        
        var dict = new Dictionary<int, int>(nums.Length);

        for (int i = 0; i < nums.Length; i++) {
            int remaining = target - nums[i];

            if (dict.TryGetValue(remaining, out int index)) {
                return new int[] { i, index };
            }

            dict[nums[i]] = i;
        }

        throw new ArgumentException("No solution exists");
    }
}
