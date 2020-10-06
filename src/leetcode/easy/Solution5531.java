package leetcode.easy;

import java.util.Arrays;

public class Solution5531 {
    public int specialArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0] >= 1 ? 1 : -1;
        }

        Arrays.sort(nums);

        int size = nums.length;

        for (int x = 1; x < size + 1; x++) {
            /*
				start searching from the end - x'th location, as array is sorted,
				we are assuming, all previous numbers should be less than x,
				if yes, then we will search, else, no need to search, just increament the x.

				so if number = 1, we will check (arraySize - 1) - number, here number is 1, so arraySize - 1 - 1.
            */
            int index = (size - 1) - x;

            /*
					if search index becomes less than 0, meaning either size of the array is already of x,
					or all numbers from end to x have been scanned and
					all of them are either greater or equal to x, if thats the case, just return x.
            */
            if (index < 0) {
                return x;
            }

            /*
					if the number at index position is less than x,
					meaning all the element after x are either greater than x or x.
					In this case, we just have to check, whether just next number is either greater or equal to x,
					if not, meaning, its less than x and hence, solution is not possible, so return -1,
					else, return x, considering the fact all numbers next to x will be greater or equal
					and thats why we sorted the array, at first point.
            */
            if (nums[index] < x) {
                return nums[++index] >= x ? x : -1;
            }
        }
        return -1;
    }

    public int specialArrayBest(int[] nums) {
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int number = nums.length;
        for (int i = 0; i <= 1000; i++) {
            if (number == i) {
                return i;
            }
            number -= count[i];
        }
        return -1;
    }


}
