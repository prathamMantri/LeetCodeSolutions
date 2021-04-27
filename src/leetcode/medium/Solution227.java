package leetcode.medium;

import java.util.Stack;

public class Solution227 {
    public int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        s.trim();
        Stack<Character> st = new Stack<>();

        int i = 0;


        while(i<s.length()){
            if(s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                char operation = s.charAt(i++);
                int prev = Character.getNumericValue(st.pop());
                i++;
                while(i<s.length() && s.charAt(i)== ' '){
                    i++;
                    continue;
                }
                int next = Character.getNumericValue(s.charAt(i++));
                int calc = operation == '*' ? prev * next : prev/next;
                st.push((char)(calc+'0'));
            }
            if(i<s.length() && s.charAt(i) != ' ')
                st.push(s.charAt(i++));
        }

        int total =0;

        while(!st.isEmpty()){
            char c = st.pop();
            if(c == '+' || c == '-')
                total = c == '+' ?  Character.getNumericValue(st.pop()) + total : Character.getNumericValue(st.pop())-total;
            else
                total = total + Character.getNumericValue(c);
        }
        return total;
    }
}
