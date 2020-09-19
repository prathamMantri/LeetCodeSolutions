package interview_questions_facebook;

import java.util.Stack;

public class BalanceBrackets {
    public static void main(String[] args) {
        BalanceBrackets balanceBrackets = new BalanceBrackets();
        System.out.println(balanceBrackets.isBalanced("{{[[(())]]}}"));
    }

    boolean isBalanced(String s) {
        // Write your code here

        if (s.equals("") || s == null)
            return true;

        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            }

            if (c == '}') {
                if (st.peek() != '{')
                    return false;
                st.pop();
            }
            if (c == ')') {
                if (st.peek() != '(')
                    return false;
                st.pop();
            }
            if (c == ']') {
                if (st.peek() != '[')
                    return false;
                st.pop();
            }
        }

        return st.isEmpty();

    }
}
