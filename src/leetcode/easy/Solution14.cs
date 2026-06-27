// https://leetcode.com/problems/longest-common-prefix/ 
public class Solution14 {
    public string LongestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.Length == 0)
        {
            return "";
        }

        StringBuilder str = new StringBuilder();
        Array.Sort(strs);
        var first = strs[0];
        var last = strs[strs.Length - 1];

        for(int i=0; i<Math.Min(first.Length, last.Length); i++)
        {
            if(first[i] != last[i])
            {
                return str.ToString();
            }
            str.Append(first[i]);
        }
        return str.ToString();
    }
}
