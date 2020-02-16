package recursion;

public class ReverseString {
/*

    public void reverseString(char[] s) {
        helper(0, s.length-1, s);
    }

    public void helper(int start, int end, char[] s){
       if(start==end || end-1==start){
           return;
       }
       char temp = s[start];
       s[start] = s[end];
       s[end] = temp;
       helper(++start, --end, s);
    }
*/


    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] str = {'h', 'e', 'l', 'l', 'o'};
        rs.reverseString(str);
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
    }

    public void reverseString(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        if (s.length == 2) {
            char temp = s[0];
            s[0] = s[1];
            s[1] = temp;
        } else {
            helper(0, s.length - 1, s);
        }
    }

    public void helper(int start, int end, char[] s) {
        if (end <= start) {
            return;
        }
        char temp = s[start];
        s[start++] = s[end];
        s[end--] = temp;
        helper(start, end, s);
    }

}
