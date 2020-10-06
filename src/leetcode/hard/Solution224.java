package leetcode.hard;

import java.util.Stack;

public class Solution224 {
    /*public int calculate(String s) {
        int i = 0;
        Stack<String> st = new Stack<>();
        int sum = 0;
        String operation;
        s.trim();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        while(i<s.length()){
            char currChar = s.charAt(i);
            if(currChar == ' '){
                i++;
                continue;
            }
            if(currChar == '('){
                int res = 0;
                while(!st.peek().equals(")")){
                    int operand1 = Integer.parseInt(st.pop());
                    operation = st.pop();
                    int operand2 = Integer.parseInt(st.pop());
                    res = performOperation(operand1, operand2, operation);
                    if(!st.peek().equals(")")){
                        st.push(res+"");
                    }else{
                        sum = sum + res;
                        st.push(sum+"");
                    }
                }
                i++;
            }else{
                st.push(currChar+"");
                i++;
            }
        }
        while(st.size()!=1){
            int operand1 = Integer.parseInt(st.pop());
            operation = st.pop();
            int operand2 = Integer.parseInt(st.pop());
            int res = performOperation(operand1, operand2, operation);
            if(st.isEmpty()){
                return sum + res;
            }else{
                st.push(res+"");
            }
        }

        return sum;
    }
    private int performOperation(int operand1, int operand2, String operation){
        return operation.equals("+") ? operand1 + operand2 : operand1 - operand2;
    }
    */
    /*
    public int calculate(String s) {
        int i = 0;
        Stack<Character> st = new Stack<>();

        StringBuilder sb = new StringBuilder(s);
        StringBuilder operand1 = new StringBuilder();
        StringBuilder operand2 = new StringBuilder();
        sb.reverse();
        s = sb.toString();

        //(1+(4+5+2)-3)+(6+8)

        // )8+6(+)3-)2+5+4(+1(

        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != '(') {
                st.push(c);
            } else {
                while (!st.isEmpty() && st.peek() != ')') {
                    while (!st.isEmpty() && Character.isDigit(st.peek())) {
                        operand1.append(st.pop());
                    }
                    char operation = '+';
                    if(!st.isEmpty()) {
                        operation = st.pop();
                    }
                    while (!st.isEmpty() && Character.isDigit(st.peek())) {
                        operand2.append(st.pop());
                    }
                    if(!st.isEmpty())
                        st.pop();
                    String res="";
                    if(operand1.length() > 0 && operand2.length() >0)
                        res = operation == '+' ? Integer.parseInt(operand1.toString()) + Integer.parseInt(operand2.toString()) + "" : Integer.parseInt(operand1.toString()) - Integer.parseInt(operand1.toString()) + "";
                    for (int j = res.length() - 1; j >= 0; j--)
                        st.push(res.charAt(j));
                    operand1 = new StringBuilder();
                    operand2 = new StringBuilder();
                }
            }
            i++;
        }
        sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return Integer.parseInt(sb.reverse().toString());
    }*/

    //https://leetcode.com/problems/basic-calculator/discuss/62430/Java-solutionStack

    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();
        int sign = 1;
        int res = 0;

        st.push(1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            else if (c == '(') {
                st.push(st.peek() * sign);
                sign = 1;
            } else if (c == ')') {
                st.pop();
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else {
                int temp = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    temp = temp * 10 + s.charAt(++i) - '0';
                res += sign * st.peek() * temp;
            }
        }
        return res;
    }

}
