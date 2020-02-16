package leetcode.easy;

import java.util.Arrays;

public class Solution26 {
    int count =0;
    int j=1;
    public int removeDuplicates(int[] nums) {

        if(nums.length==0){
            return count;
        }else{
            count=1;
        }

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[j] = nums[i];
                count++;
                j++;
            }
        }

        Arrays.copyOf(nums, j);

        return count;
    }
}
