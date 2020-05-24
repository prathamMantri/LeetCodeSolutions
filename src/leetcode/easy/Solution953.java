package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution953 {
    public static void main(String[] args) {

        String[] words = {"kuvp", "q"};
        String orders = "ngxlkthsjuoqcpavbfdermiywz";

        Solution953 sol = new Solution953();
        System.out.println(sol.isAlienSorted(words, orders));
    }

    public boolean isAlienSorted(String[] words, String order) {


        List<Character> orders = new ArrayList<>();
        Boolean res = true;

        for (int i = 0; i < order.length(); i++) {
            orders.add(i, order.charAt(i));
        }


        for (int i = 0; i <= words.length - 2; i++) {
            if (res) {
                res = compare(words[i], words[i + 1], orders);
                if (words[i].length() > words[i + 1].length()) {
                    return false;
                }
            } else
                return false;
        }
        return res;
    }

    public boolean compare(String s1, String s2, List<Character> orders) {
        for (int i = 0; i <= Math.min(s1.length(), s2.length()) - 1; i++) {
            if (orders.indexOf(s1.charAt(i)) > orders.indexOf(s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
