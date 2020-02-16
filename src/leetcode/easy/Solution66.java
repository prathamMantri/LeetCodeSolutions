package leetcode.easy;

public class Solution66 {

    public int[] plusOne(int[] digits) {

        int carry = 1;

        int[] result = new int[digits.length];

        int i = digits.length-1;

        while(i>=0){
            if(digits[i]==9 && carry==1){

                if(i==0){
                    int[] result2 = new int[result.length+1];
                    System.arraycopy(result, 0, result2, 1, result.length);
                    result2[0] = 1;
                    return result2;
                }

                result[i] = 0;
                carry = 1;
                i--;
            }else{
                result[i] = digits[i]+carry;
                carry = 0;
                i--;
            }
        }

        return result;

    }

    public static void main(String[] args){

        Solution66 solution66 = new Solution66();
        int[] digits = {9,8,7,6,5,4,3,2,1,0};
        solution66.plusOne(digits);




    }
}
