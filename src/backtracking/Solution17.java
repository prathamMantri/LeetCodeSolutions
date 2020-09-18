package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution17 {

    /****
     Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

     A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



     Example:

     Input: "23"
     Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     Note:

     Although the above answer is in lexicographical order, your answer could be in any order you want.
     ********/

    List<String> result = new ArrayList<>();
    HashMap mappings = new HashMap() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public void backtrack(String combination, String next_digits) {

        if (next_digits.length() == 0) {
            result.add(combination);
        }

        String digit = next_digits.substring(0, 1);

        for (int i = 0; i < ((String) mappings.get(digit)).length(); i++) {
            String letter = ((String) mappings.get(digit)).substring(i, i + 1);
            backtrack(combination + letter, next_digits.substring(1));
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0 && digits != null)
            backtrack("", digits);
        return result;
    }

    //Another approach

    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            list.add(letters[Integer.parseInt(c + "")]);
        }
        helper(res, list, new StringBuilder(), 0);
        return res;
    }

    void helper(List<String> res, List<String> list, StringBuilder sb, int position) {
        if (sb.length() == list.size()) {
            res.add(sb.toString());
            return;
        }
        for (char c : list.get(position).toCharArray()) {
            sb.append(c);
            helper(res, list, sb, position + 1);
            sb.setLength(sb.length() - 1);
        }
    }


}
