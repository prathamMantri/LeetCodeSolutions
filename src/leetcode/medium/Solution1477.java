package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution1477 {


    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        int[] min = new int[arr.length];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            //prefix sum
            sum += arr[i];

            //if i = 0, then store the min[i] with max value, else min [i-1];
            // min of i will eventually change once we find target subArray, so for next iteration it will be of that length.
            //otherwise, it will keep on getting updated with MAX value, as it takes previous element.
            min[i] = i > 0 ? min[i - 1] : Integer.MAX_VALUE;
            // if map contains value for prefix sum - target
            if (map.containsKey(sum - target)) {
                //get the previous index, where the target found previously.
                int pre = map.get(sum - target);

                // update the min value at index i, with current value,
                //        which could either be MAX_VAL,
                //        or previously found index
                //        it wont have -1 as, remember, we are putting MAX_VAL (at start) if index is 0, and then its getting updated, if target is found at 0 by below code.
                min[i] = Math.min(min[i], i - pre);

                //
                // if pre equals -1 means, till now we only got one sub-array whose sum equals the target
                // and if min[pre], where pre is the index value from map is not equal to max value, then calculate the res
                if (pre != -1 && min[pre] != Integer.MAX_VALUE) {

                    // min[pre] is previously found array, and i - pre is currently found subArray length.
                    // here, getting minimum is the aim, not whic minimum, so just find min res, by adding each subarray length
                    res = Math.min(res, min[pre] + i - pre);
                }
            }
            // keep on putting prefix sum with its index in map.
            map.put(sum, i);
        }
        // if res is Integer.MAX_VALUE, meaning, we did not find second subArray, as first subArray will have MAX value only.
        // why, it will have max value, because res is getting only when pre is not -1, and for first subarray it will be -1.,
        // which will get updated once we find second subArray using.
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int minSumOfLengths1(int[] arr, int target) {
        int[] prefixSum = new int[arr.length + 1];
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
            indexMap.put(prefixSum[i + 1], i);
        }

        int left = Integer.MAX_VALUE;
        int right = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < prefixSum.length; i++) {
            if (indexMap.containsKey(prefixSum[i] - target)) {
                int prevIdx = indexMap.get(prefixSum[i] - target);
                left = Math.min(left, i - prevIdx);
            }

            if (indexMap.containsKey(prefixSum[i] + target)) {
                int nextIdx = indexMap.get(prefixSum[i] + target);
                right = nextIdx - i;
                if (left != Integer.MAX_VALUE) {
                    result = Math.min(result, right + left);
                }
            }
        }
        if (result == Integer.MAX_VALUE)
            return -1;
        return result;
    }

}
