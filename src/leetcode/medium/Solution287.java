package leetcode.medium;

public class Solution287 {
    //Using Binary Search

    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i : nums)
                if (i <= mid)
                    count++;
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    // Using Floyd's Tortoise and Hare algorithm
  /*
     public int findDuplicate(int[] nums) {
         int hare = nums[0];
         int tortoise = nums[0];
         do{
             hare = nums[nums[hare]];
             tortoise = nums[tortoise];
         }while(hare!=tortoise);
         tortoise = nums[0];
         while(tortoise!=hare){
             tortoise = nums[tortoise];
             hare = nums[hare];
         }
         return hare;
     }
    */

    /*
    public int findDuplicate(int[] nums) {

        for (int n : nums) {
            if (nums[Math.abs(n)] < 0) {
                return Math.abs(n);
            } else {
                nums[Math.abs(n)] *= -1;
            }
        }
        return -1;
    }
    */


}
