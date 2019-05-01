package leetCode.medium;

public class Solution55 {

    /***
     *
     *
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * Example 1:
     *
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     *              jump length is 0, which makes it impossible to reach the last index
     **/

  /*  public boolean canJump(int[] nums) {
        int endIndex = nums.length - 1;
        int startIndex = endIndex - 1;
        if(nums.length<2){
            return true;
        }
        while(startIndex!=0){
            if(nums[startIndex] >= endIndex - startIndex){
                endIndex = startIndex;
                if(startIndex<1){
                    return true;
                }
            }else{
                if(startIndex<0){
                    return false;
                }
            }
            startIndex--;
        }
        return nums[startIndex] >= (endIndex - startIndex);
    }*/

        public boolean canJump(int[] nums) {
            int i = nums.length-1;
            int lastIndex = nums.length-1;
            boolean canJumpFlag = false;
            while(i>    0){
                if(lastIndex - (--i) <= nums[i] ){
                    canJumpFlag = true;
                    lastIndex = i;
                }else{
                    canJumpFlag = false;
                }
            }
            return canJumpFlag;
    }

    public static void main(String args[]){
        Solution55 sol = new Solution55();
        int[] a = {1,2,0,0,0};
        System.out.println(sol.canJump(a));
    }
}
