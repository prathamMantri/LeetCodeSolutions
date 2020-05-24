package leetcode.easy;

public class Solution67 {
    public static void main(String[] args) {
        Solution67 sol = new Solution67();
        System.out.println(sol.addBinary2("11", "1"));
    }

    public String addBinary1(String a, String b) {
        char carry = '0';
        StringBuilder stringBuilder = new StringBuilder();

        int len = Math.max(a.length(), b.length());

        int i = a.length() - 1;
        int j = b.length() - 1;



        while(len>0){

            char aChar = i <= a.length() - 1 && i>=0 ? a.charAt(i) : '0';
            char bChar = j <= b.length() - 1 && j>=0 ? b.charAt(j) : '0';

            if (aChar == '0' && bChar == '0') {
                stringBuilder.insert(0, carry == '1' ? '1' : '0');
                carry = '0';
            }
            else if ((aChar == '1' && bChar == '0') || (aChar == '0' && bChar == '1')) {
                stringBuilder.insert(0, carry == '1' ? '0' : '1');
                if (carry == '1')
                    carry = '1';
            }
            else if (aChar == '1' && bChar == '1') {
                stringBuilder.insert(0, carry == '1' ? '1' : '0');
                carry = '1';
            }

            len--;
            j--;
            i--;
        }

        if (carry == '1') {
            stringBuilder.insert(0, '1');
        }

        return stringBuilder.toString();

    }

    public String addBinary2(String a, String b) {

        if (a.length() > b.length())
            return addBinary(a.length() - b.length(), b, a);
        else
            return addBinary(b.length() - a.length(), a, b);


    }

    public String addBinary(int diff, String min, String max) {

        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < diff; i++) {
            sb.append('0');
        }

        sb.append(min);

        min = sb.toString();
        int carry = 0;
        int result = 0;

        for (int i = min.length() - 1; i >= 0; i--) {

            int minBinary = Integer.parseInt(String.valueOf(min.charAt(i)));
            int maxBinary = Integer.parseInt(String.valueOf(max.charAt(i)));

            if (minBinary == 1 && maxBinary == 1) {
                result = carry;
                carry = 1;
            } else if (minBinary == 0 && maxBinary == 0) {
                result = carry;
                carry = 0;
            } else if (carry == 1) {
                result = 0;
                carry = 1;
            } else {
                result = 1;
                carry = 0;
            }

            res.append(result);

        }

        return res.append(carry == 0 ? "" : carry).reverse().toString();

    }
}
