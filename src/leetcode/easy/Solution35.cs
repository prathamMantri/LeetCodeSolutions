// https://leetcode.com/problems/search-insert-position/

public class Solution35 {
    public int SearchInsert(int[] nums, int target) {
        int i=0;
        int j= nums.Length-1;

        while(i<=j)
        {
            int mid = i + (j-i)/2;
            if(target == nums[mid])
            {
                return mid;
            }
            else if(target < nums[mid])
            {
                j = mid-1;
            }
            else
            {
                i = mid+1;
            }
        }
        return i;
    }
}
