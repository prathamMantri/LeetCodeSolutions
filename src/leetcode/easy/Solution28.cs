// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

public class Solution28 {
    public int StrStr(string haystack, string needle) {

        if(haystack.Length < needle.Length)
        {
            return -1;
        }   

        for(int i=0; i<=haystack.Length - needle.Length; i++)
        {
            int j = 0;

            while(j<needle.Length && haystack[i+j] == needle[j])
            {
                j++;
            }
            if(j == needle.Length)
            {
                return i;
            }
        }
        return -1;
    }
}
