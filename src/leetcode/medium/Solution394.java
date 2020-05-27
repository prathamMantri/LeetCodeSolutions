package leetcode.medium;

public class Solution394 {
    public String decodeString(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        return expand(new StringBuilder(), s); // a helper expand function

    }

    public String expand(StringBuilder sb, String append) {
        int i = 0;
        while (i < append.length()) {
            char c = append.charAt(i);
            if (Character.isDigit(c)) { //check if its a digit
                StringBuilder times = new StringBuilder();
                times.append(c); // number could be more than 9, so appending it to times StringBuilder object
                StringBuilder insideAppend = new StringBuilder();
                int j = i + 1; //check the next element
                int count = 0;
                Boolean numberContinues = true; //set it to true untill next char is '['
                while (true && j < append.length()) {
                    char ic = append.charAt(j);
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
    }
}
