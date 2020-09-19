package mock_interviews;


import java.util.HashMap;
import java.util.Map;

public class MockWithEdith {

    /*

    Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
Example 1:

Input: "42"
Output: 42
Example 2:

Input: "   42 - djfh  "
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
     */
    //42 = 40 + 2 = 10^1 * 4 + 10^0 *2

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }

        String newString = str.trim();
        if (newString.length() == 0) {
            return 0;
        }
        Map<Character, Integer> intMap = new HashMap<>();

        intMap.put('0', 0);
        intMap.put('1', 1);
        intMap.put('2', 2);
        intMap.put('3', 3);
        intMap.put('4', 4);
        intMap.put('5', 5);
        intMap.put('6', 6);
        intMap.put('7', 7);
        intMap.put('8', 8);
        intMap.put('9', 9);

        boolean minusFlag = false;
        StringBuilder stringBuffer = new StringBuilder();
        int count = 0;
        for (Character ch : newString.toCharArray()) {
            if (ch == '-' && count == 0) {
                minusFlag = true;
            } else if (ch == '+' && count == 0) {
                minusFlag = false;
            } else if (intMap.get(ch) != null) {
                stringBuffer.append(ch);
            } else {
                break;
            }
            count++;
        }
        String digits = stringBuffer.toString();
        int len = digits.length();
        if (len > 10) {
            return minusFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        // 2 1 4 7 4 8 3 6 4 7
        Integer sum = 0;
        int power = 0;
        //digits = 1 2 3 4 5
        for (int i = len - 1; i >= 0; i--) {
            int digit = intMap.get(digits.charAt(i));
            if (sum == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10) {
                return minusFlag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            sum = sum + digit * (int) Math.pow(10, power);
            power++;
        }
        return minusFlag ? sum * (-1) : sum;
    }

}
