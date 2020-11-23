package leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class Solution753 {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int goal = (int) Math.pow(k, n);
        for (int i = 0; i < n; i++) sb.append('0');
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(n, k, goal, sb, visited);
        return sb.toString();
    }

    private boolean dfs(int n, int k, int goal, StringBuilder sb, Set<String> visited) {
        if (visited.size() == goal) return true;
        String prev = sb.substring(sb.length() - n + 1, sb.length());
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (dfs(n, k, goal, sb, visited)) return true;
                else {
                    visited.remove(next);
                    sb.delete(sb.length() - 1, sb.length());
                }
            }
        }
        return false;
    }
}
