// https://leetcode.com/problems/plus-one/


public class Solution66 {
    public int[] PlusOne(int[] digits) {
        
        Stack<int> result =new Stack<int>();
        int sum = 0;

        int carry = 1;

        for(int i=digits.Length-1; i>=0; i--)
        {
            if(digits[i] == 9 && carry == 1)
            {
                carry = 1;
            }
            else
            {
                sum = carry + digits[i];
                carry = 0;
            }
            result.Push((digits[i] == 9 && carry == 1) ? 0 : sum);
        }
        if(carry == 1)
        {
            result.Push(1);
        }
        return result.ToArray();
    }
}
