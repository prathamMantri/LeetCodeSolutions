// https://leetcode.com/problems/sqrtx/

public class Solution {
    public int MySqrt(int x) {
        if(x == 0)
        {
            return 0;
        }
        
        int start = 1;
        int end = x/2;

        while(end >= start)
        {
            int mid = start + (end - start)/2;
            long sqrt = (long)mid * mid;

            if(sqrt == x)
            {
                return mid;
            }
            else if(sqrt > x)
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return end;
    }
}
