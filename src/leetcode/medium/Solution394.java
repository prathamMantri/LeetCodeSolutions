package leetcode.medium;

import java.util.Stack;

public class Solution394 {
    /*public String decodeString(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        return expand(new StringBuilder(), s); // a helper expand function
    }
    public String expand(StringBuilder sb, String s) {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { //check if its a digit
                StringBuilder times = new StringBuilder();
                times.append(c); // number could be more than 9, so appending it to times StringBuilder object
                StringBuilder insideAppend = new StringBuilder();
                int j = i + 1; //check the next element
                int count = 0;
                Boolean numberContinues = true; //set it to true until next char is '['
                while (j < s.length()) {
                    char ic = s.charAt(j);
                    if (Character.isDigit(ic) && numberContinues) {
                        times.append(ic); // keep on appending until we find other character than number
                    } else {
                        if (ic == '[') {
                            count++; // increament count if we get nested bracket
                            numberContinues = false; //make it false as we found the character
                        }
                        if (ic == ']') {
                            count--; //decreament count as nested brackets are getting closed
                            numberContinues = false;
                        }
                        if (count == 0) {
                            break; // break the loop, once last bracket is closed
                        }
                        insideAppend.append(ic); //keep on appending the characters inside the first bracket including numbers and nested brackets, as we will send this String to our recusive function.
                    }
                    j++;
                }
                for (int k = 0; k < Integer.parseInt(times.toString()); k++) { // loop to get string desired number of "times"
                    sb.append(expand(new StringBuilder(), insideAppend.toString()));
                }
                i = j;
            }
            if (c == '[' || c == ']') {
                i++; // ignore the first and last bracket
            }
            if (Character.isLetter(c)) {
                sb.append(c); // append the char
                i++;
            }
        }
        return sb.toString();
    }*/

  /*  public String decodeString(String s) {
        return expand(1, s);
    }

    public String expand(int k, String s) {
        if (k == 0) {
            return s;
        }
        StringBuilder times;
        StringBuilder sb;
        StringBuilder res = new StringBuilder();

        int bracket = 0;
        //abc
        for (int i = 0; i < k; i++) {
            sb = new StringBuilder();
            times = new StringBuilder("0");
            int loop;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (Character.isDigit(c)) {
                    times.append(c);
                    continue;
                } else if (c == '[') {
                    loop = Integer.parseInt(times.toString());
                    if (bracket > 0) {
                        sb.append(c);
                    }
                    bracket++;
                } else if (c == ']') {
                    bracket--;
                    if (bracket > 0)
                        sb.append(c);
                    else {
                        int loop = Integer.parseInt(times.toString());
                        times = new StringBuilder("0");
                        res.append(expand(loop, sb.toString()));
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(c);
                }
            }
            res.append(sb.toString());
        }
        return res.toString();
    }*/


    public String decodeString(String s) {
        int i = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder times = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != ']') {
                st.push(c);
            } else {
                while (st.peek() != '[') {
                    char currentChar = st.pop();
                    sb.append(currentChar);
                }
                st.pop();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    times.append(st.pop());
                }
                times.reverse();
                int loop = 1;
                if (times.length() > 0) {
                    loop = Integer.parseInt(times.toString());
                }
                for (int j = 0; j < loop; j++) {
                    String newString = sb.toString();
                    for (int k = newString.length() - 1; k >= 0; k--) {
                        st.push(newString.charAt(k));
                    }
                }
                sb = new StringBuilder();
                times = new StringBuilder();
            }
            i++;
        }
        sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }


}
