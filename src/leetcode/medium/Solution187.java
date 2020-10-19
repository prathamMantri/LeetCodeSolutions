package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution187 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> mainRes = new ArrayList<>();
        Set<String> res = new HashSet<>();
        Set<String> subsequence = new HashSet<>();
        int i = 0;
        int j = 9;

        while (j < s.length()) {
            if (!subsequence.add(s.substring(i, j + 1)))
                res.add(s.substring(i, j + 1));
            i++;
            j++;
        }
        mainRes.addAll(res);
        return mainRes;
    }
}
