package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {

    public List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        for (char c : S.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                StringBuilder sb = new StringBuilder();
                sb.append((c + "").toUpperCase()).append((c + "").toLowerCase());
                list.add(sb.toString());
            } else {
                list.add(c + "");
            }
        }

        letterCasePermutation(res, list, new StringBuilder(), 0);

        return res;

    }

    void letterCasePermutation(List<String> res, List<String> list, StringBuilder sb, int pos) {

        if (sb.length() == list.size()) {
            res.add(sb.toString());
            return;
        }
        for (char c : list.get(pos).toCharArray()) {
            sb.append(c);
            letterCasePermutation(res, list, sb, pos + 1);
            sb.setLength(sb.length() - 1);
        }
    }


}
