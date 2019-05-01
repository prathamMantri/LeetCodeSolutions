package leetCode.easy;

import hackerRank.Solution;

public class Solution58 {

/*

    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

            Example:

    Input: "Hello World"
    Output: 5

*/

    public int lengthOfLastWord(String s){
        int count=0;
        int i= s.trim().length()-1;
        for(;i>=0;i--){
            if(s.trim().charAt(i)==' ')
                return count;
            count++;
        }
        return count;
    }

    public static void main(String args[]){

        Solution58 sol = new Solution58();
        System.out.println(sol.lengthOfLastWord(" abc"));


    }
}
