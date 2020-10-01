package leetcode.easy;

public class Solution198 {


    /*

        For 1  Rob the current house

        For 2 Rob max of (1 , 2)
        For 3 Rob max of (3 + 1,  2)
        For 4 Rob max of (4 + 2, 3 + 1);
        For 5 Rob max of (5 + 3 + 1, 4+2)
        For 6 Rob max of (6 + 4 + 2, 5 + 3 + 1)


   int[] nums = { 2,  1,  1,  4,  1,  1,  6};

     int[] nums = { 2,       1,      1,      4,      1,      1,      6};
     //             2        2       3       6       6       7       12
     */

    public int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;

        int[] mem = new int[num.length];
        if (num.length > 1) {

            mem[0] = num[0];
            mem[1] = Math.max(num[0], num[1]);
            for (int x = 2; x < num.length; x++) {

                mem[x] = Math.max(mem[x - 2] + num[x], mem[x - 1]);
                /*int temp = currMax;
                currMax = Math.max(prevMax + x, currMax);
                prevMax = temp;*/
            }
            return mem[num.length - 1];
        }
        return num[0];
    }


}
