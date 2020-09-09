package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    /*    public List<Integer> findDuplicates(int[] nums) {
        if(nums.length==1){
            return null;
        }

        List<Integer> res= new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int temp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = temp;
        }

        for(int i=0; i<nums.length; i++){

            if(nums[i] != i+1){
                res.add(i+1);
            }
        }
        return res;
    }*/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(i + 1);
        }
        for (int num : nums) {
            if (res.contains(num))
                res.remove((Integer) num);
        }
        return res;
    }

    //Pre-filling the result list will be considered as O(n) space? If not, introducing Java Solution
}
