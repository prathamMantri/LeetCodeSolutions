// https://leetcode.com/problems/remove-element/

public class Solution27 {
    public int RemoveElement(int[] nums, int val) {

        if(nums.Length ==  0)
        {
            return 0;
        }

        int index = 0;
        int lastIndex = nums.Length - 1;
        
        while(index <= lastIndex)
        {
            if(nums[lastIndex] == val)
            {
                lastIndex--;
                continue;
            }
            if(nums[index] == val)
            {
                nums[index] = nums[lastIndex--];
            }
            index++;
        }
        return index;
    }
}
