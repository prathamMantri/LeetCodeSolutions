package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution345 {
    public static void main(String[] args) {
        Solution345 sol = new Solution345();
        System.out.println(sol.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {

        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        char[] sCharArray = s.toCharArray();

        if (s == null || s.length() == 0) {
            return "";
        }

        int i = 0, j = s.length() - 1;

        while (i < j) {

            if (vowels.contains(s.charAt(i)) && vowels.contains(s.charAt(j))) {
                char temp = sCharArray[i];
                sCharArray[i] = sCharArray[j];
                sCharArray[j] = temp;
                i++;
                j--;
            } else if (!vowels.contains(s.charAt(i)) && vowels.contains(s.charAt(j))) {
                i++;
            } else if (vowels.contains(s.charAt(i)) && !vowels.contains(s.charAt(j))) {
                j--;
            } else {
                i++;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : sCharArray) {
            sb.append(c);
        }
        return sb.toString();
    }
}
