// https://leetcode.com/problems/longest-palindromic-substring/

public class Solution {
    public string LongestPalindrome(string s) {
        if(s==null || s.Length < 1)
        {
            return "";
        }
        string result = "";

        for(int i=0; i<s.Length; i++)
        {
            // odd 
            int low = i;
            int high = i;
            while(low >= 0 && high < s.Length && s[low] == s[high])
            {
                low--;
                high++;
            }
            string palindrome = s.Substring(low+1, high-low-1);

            if(result.Length < palindrome.Length)
            {
                result = palindrome;
            }

            // even

            low = i-1;
            high = i;
            while(low >= 0 && high < s.Length && s[low] == s[high])
            {
                low--;
                high++;
            }
            palindrome = s.Substring(low+1, high-low-1);

            if(result.Length < palindrome.Length)
            {
                result = palindrome;
            }
        }
        return result;
    }
   


}
