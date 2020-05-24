package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public static void main(String[] args) {

        Solution13 sol = new Solution13();

        System.out.println(sol.romanToInt("MCMXCIV"));


    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i = 0;
        int res = 0;
        while (i < s.length()) {

            char c = s.charAt(i);

            if (i < s.length() - 1) {
                char nextC = s.charAt(i + 1);
                switch (c) {
                    case 'I':
                        switch (nextC) {
                            case 'V':
                                res = res + map.get('V') - 1;
                                i = i + 2;
                                break;
                            case 'X':
                                res = res + map.get('X') - 1;
                                i = i + 2;
                                break;
                            default:
                                res = res + map.get(c);
                                i++;
                                break;
                        }
                        break;
                    case 'X':
                        switch (nextC) {
                            case 'L':
                                res = res + map.get('L') - 10;
                                i = i + 2;
                                break;
                            case 'C':
                                res = res + map.get('C') - 10;
                                i = i + 2;
                                break;
                            default:
                                res = res + map.get(c);
                                i++;
                                break;
                        }
                        break;
                    case 'C':
                        switch (nextC) {
                            case 'D':
                                res = res + map.get('D') - 100;
                                i = i + 2;
                                break;
                            case 'M':
                                res = res + map.get('M') - 100;
                                i = i + 2;
                                break;
                            default:
                                res = res + map.get(c);
                                i++;
                                break;
                        }
                        break;
                    default:
                        res = res + map.get(c);
                        i++;
                        break;

                }
            } else {
                res = res + map.get(s.charAt(i));
                i++;
            }
        }
        return res;
    }

}
