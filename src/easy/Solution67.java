package easy;

public class Solution67 {
    public String addBinary(String a, String b) {
        char carry = '0';
        StringBuilder stringBuilder = new StringBuilder();

        int len = Math.max(a.length(), b.length());

        int i = a.length()-1;
        int j = b.length()-1;



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

    public static void main(String args[]){
        Solution67 sol = new Solution67();
        System.out.println(sol.addBinary("11", "1"));
    }
}
