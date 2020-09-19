package monthly_challange;

/*

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.

 */


public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray sol = new ContiguousArray();
        int[] nums = {0, 1, 1, 0, 1, 1, 1, 0};
        //int[] nums = {0,0,1,0,0,0,1,1};
        System.out.println(sol.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        int res = 0;
        int flag = 0;
        int count = 0;
        int zeroCount = 0;
        int oneCount = 0;


        for (int i : nums) {
            if (i == 0) {
                flag++;
                zeroCount++;
            } else {
                flag--;
                oneCount++;
            }
            count++;
            if (flag == 0) {
                res = Math.max(count, res);
            }
        }

       /* System.out.println("oneCount " +oneCount);
        System.out.println("zeroCount " +zeroCount);
        System.out.println("totalCount " + count);*/
        //return Math.max(res, count - Math.abs(zeroCount-oneCount));
        return res;
    }


}
