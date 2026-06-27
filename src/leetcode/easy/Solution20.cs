// https://leetcode.com/problems/valid-parentheses/description/

public class Solution20 {
    public bool IsValid(string s) {
        HashSet<char> openingParenthesis = new HashSet<char>() {'(', '{', '['};
        HashSet<char> closingParenthesis = new HashSet<char>() {')', '}', ']'};
        Stack<char> parenthesis = new Stack<char>();
        if(string.IsNullOrEmpty(s))
        {
            return true;
        }

        for(int i=0; i<s.Length; i++)
        {
            if(i == s.Length && parenthesis.Count != 0)
            {
                return false;
            }

            if (openingParenthesis.Contains(s[i]))
            {
                parenthesis.Push(s[i]);
            }
            else
            {
                if(parenthesis.Count == 0)
                {
                    return false;
                }

                if ((s[i] == ')' && parenthesis.Peek() != '(') ||
                (s[i] == '}' && parenthesis.Peek() != '{') ||
                (s[i] == ']' && parenthesis.Peek() != '['))
                {
                    return false;
                }
                else{
                    parenthesis.Pop();
                }
            }
        }

        return parenthesis.Count == 0;
    }
}
