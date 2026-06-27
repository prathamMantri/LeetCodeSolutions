// https://leetcode.com/problems/length-of-last-word/

public class Solution58 {
    public int LengthOfLastWord(string s) {
        if(string.IsNullOrEmpty(s))
        {
            return 0;
        }
        
        string trimmed = s.Trim();

        int end = trimmed.Length-1;

        int count = 0;

        while(end >= 0 && trimmed[end] != ' ')
        {
            end--;
            count++;
        }
        return count;
    }
}
