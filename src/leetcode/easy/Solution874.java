package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution874 {
    public static void main(String[] args) {
        Solution874 sol = new Solution874();
        System.out.println(sol.addStrings("6000", "105"));
    }

    public String addStrings(String num1, String num2) {

        Map<String, Integer> map = new HashMap<>();

        map.put("0", 0);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);

        String min = num1.length() <= num2.length() ? num1 : num2;
        String max = num1.length() > num2.length() ? num1 : num2;

        StringBuilder sb = new StringBuilder();
        int size = max.length() - min.length();
        for (int i = 0; i < size; i++) {
            sb.insert(0, 0);
        }

        min = sb.append(min).toString();

        return findSum(min, max, map);

    }

    private String findSum(String min, String max, Map<String, Integer> map) {
        int carry = 0;
        StringBuilder res = new StringBuilder();

        for (int i = min.length() - 1; i >= 0; i--) {
            int sum = map.get("" + min.charAt(i)) + map.get("" + max.charAt(i)) + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            res.append(sum);
        }

        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

}
