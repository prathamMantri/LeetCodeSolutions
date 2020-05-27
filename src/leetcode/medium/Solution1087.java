package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1087 {

    // Reference from https://www.youtube.com/watch?v=tJPpHxPEXX0 Thanks @happygirlzt

    public static void main(String[] args) {
        Solution1087 sol = new Solution1087();
        System.out.println(Arrays.toString(sol.expand("{a,b}c{d,e}f")));
    }

    public String[] expand(String S) {

        List<String> list = new ArrayList<>();
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '{') {
                StringBuilder sb = new StringBuilder();
                int j = i + 1;
                while (j < n && S.charAt(j) != '}') {
                    if (S.charAt(j) == ',') {
                        j++;
                        continue;
                    }
                    sb.append(S.charAt(j));
                    j++;
                }
                list.add(sb.toString());
                i = j;
            } else {
                list.add(S.charAt(i) + "");
            }
        }
        List<String> res = new ArrayList<>();
        dfs(list, res, new StringBuilder(), 0);
        String[] result = new String[res.size()];
        int i = 0;
        for (String s : res) {
            result[i++] = s;
        }
        Arrays.sort(result);
        return result;
    }

    void dfs(List<String> list, List<String> res, StringBuilder sb, int position) {

        if (sb.length() == list.size()) {
            res.add(sb.toString());
            return;
        }

        for (char c : list.get(position).toCharArray()) {
            sb.append(c);
            dfs(list, res, sb, position + 1);
            sb.setLength(sb.length() - 1);
        }
    }


}
