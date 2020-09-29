package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            boolean matches = true;
            int i = 0;
            int j = 0;
            while (i < query.length() && j < pattern.length()) {
                StringBuilder qu = new StringBuilder();
                StringBuilder pat = new StringBuilder();
                while (i < query.length() && !Character.isUpperCase(query.charAt(i))) {
                    i++;
                }
                while (j < pattern.length() && !Character.isUpperCase(pattern.charAt(j))) {
                    j++;
                }
                if (i == query.length() || j == pattern.length()) {
                    break;
                }
                if (i < query.length())
                    qu.append(query.charAt(i));
                if (j < pattern.length())
                    pat.append(pattern.charAt(j));
                i++;
                j++;
                while (i < query.length() - 1 && !Character.isUpperCase(query.charAt(i))) {
                    i++;
                    qu.append(query.charAt(i));
                }
                while (j < pattern.length() - 1 && !Character.isUpperCase(pattern.charAt(j))) {
                    j++;
                    pat.append(pattern.charAt(j));

                }
                matches = matches && matches(qu.toString(), pat.toString());
            }
            matches = matches && i == query.length() && j == pattern.length();
            res.add(matches);
        }
        return res;
    }

    private boolean matches(String query, String prefix) {
        int i = 0;
        int j = 0;
        while (i < query.length() && j < prefix.length()) {
            if (prefix.charAt(j) == query.charAt(i++)) {
                j++;
            }
        }
        return j == prefix.length();
    }
}
