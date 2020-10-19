package leetcode.easy;

import java.util.Arrays;

public class Solution16 {
    //https://leetcode.com/problems/3sum-closest/discuss/164611/Logical-Thinking-with-Code-Beats-99.33
    // o(n^2)
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }
//sort  the array
        Arrays.sort(nums);

        //sumClosest initialise with -1
        // minDiff with max value
        int n = nums.length, minDiff = Integer.MAX_VALUE, sumClosest = -1;

        for (int pre = 0; pre < n; pre++) {
            //start with current + 1 and last element and keep on increasing current and accordingly next.
            int lo = pre + 1;
            int hi = n - 1;
            //loop, while lo doesnt meet high
            while (lo < hi) {

                // currentTarget will be target - currentValue // Now problem is twoSum
                int curTarget = target - nums[pre];


                //get CurrSum from lo and hi index value.
                int curSum = nums[lo] + nums[hi];

                //if currSum is less than currentTarget, change the minDiff if curTarget - currSum is less than min diff, if yes, change minDiff and sumClosest and increase the lo

                if (curSum < curTarget) {
                    if (curTarget - curSum < minDiff) {
                        minDiff = curTarget - curSum;
                        sumClosest = curSum + nums[pre];
                    }
                    lo++;
                    continue;
                }


                //if currSum is greater than currentTarget, change the minDiff if currSum - currSum is less than min diff, if yes, change minDiff and sumClosest and increase the hi
                if (curSum > curTarget) {
                    if (curSum - curTarget < minDiff) {
                        minDiff = curSum - curTarget;
                        sumClosest = curSum + nums[pre];
                    }
                    hi--;
                    continue;
                }
                // otherwise its equal and return the value.
                return curSum + nums[pre];
            }
        }
//finally, return sumClosest, as it will be updated to using minDiff value.
        return sumClosest;
    }
}
