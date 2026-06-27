// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class Solution26 {
    public int RemoveDuplicates(int[] nums) {
        int index =0;
        int uniqueIndex = 0;

        while(index <= nums.Length-1)
        {
            if(nums[uniqueIndex] == nums[index])
            {
                index++;
            }
            else
            {
                uniqueIndex++;
                nums[uniqueIndex] = nums[index];
            }
            
        }
        
        return uniqueIndex+1;

    }
}
