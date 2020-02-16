package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution43 {

    public String multiply(String num1, String num2) {
         /*   int m = num1.length(), n = num2.length();
            int[] pos = new int[m + n];

            for(int i = m - 1; i >= 0; i--) {
                for(int j = n - 1; j >= 0; j--) {
                    int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int p1 = i + j, p2 = i + j + 1;
                    int sum = mul + pos[p2];

                    pos[p1] += sum / 10;
                    pos[p2] = (sum) % 10;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
            return sb.length() == 0 ? "0" : sb.toString();
        }*/

       Map<Character, Integer> numberMap = new HashMap<>();

        numberMap.put('0', 0);
        numberMap.put('1',1);
        numberMap.put('2', 2);
        numberMap.put('3', 3);
        numberMap.put('4', 4);
        numberMap.put('5', 5);
        numberMap.put('6', 6);
        numberMap.put('7', 7);
        numberMap.put('8', 8);
        numberMap.put('9', 9);

        Map<Long, Character> stringMap = new HashMap<>();

        stringMap.put(0l, '0');
        stringMap.put(1l, '1');
        stringMap.put(2l, '2');
        stringMap.put(3l, '3');
        stringMap.put(4l, '4');
        stringMap.put(5l, '5');
        stringMap.put(6l, '6');
        stringMap.put(7l, '7');
        stringMap.put(8l, '8');
        stringMap.put(9l, '9');


        return convertNumber(getNumber(num1, numberMap)*getNumber(num2, numberMap), stringMap);
    }

    private Long getNumber(String number, Map<Character, Integer> numberMap){

        Integer len = number.length();
        Long j=1l;
        Long result = 0l;

        for(int i=len-1; i>=0; i--){
            result = result + numberMap.get(number.charAt(i))*j;
            j=j*10;
        }
        return result;
    }

    private String convertNumber(Long result, Map<Long, Character> stringMap){
        StringBuilder resultString = new StringBuilder();
        while(result/10l != 0l){
            resultString.insert(0, stringMap.get(result%10l));
            result = result/10l;
            if(result==0l){
                break;
            }
        }
        resultString.insert(0, stringMap.get(result%10l));
        return resultString.toString();
    }


    public static void main(String[] args) {
        Solution43 sol = new Solution43();
        System.out.println(sol.multiply("498828660196","840477629533"));
    }
}
