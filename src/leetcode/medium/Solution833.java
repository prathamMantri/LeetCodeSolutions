package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        if (S.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < indexes.length; i++) {
            indexMap.put(indexes[i], i);
        }
        int i = 0;
        while (i < S.length()) {
            if (indexMap.containsKey(i) && S.startsWith(sources[indexMap.get(i)], i)) {
                sb.append(targets[indexMap.get(i)]);
                i = i + sources[indexMap.get(i)].length();
            } else {
                sb.append(S.charAt(i++));
            }
        }
        return sb.toString();
    }
}
