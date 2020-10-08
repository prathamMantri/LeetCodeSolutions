package leetcode.medium;

public class Solution777 {
    public boolean canTransform(String start, String end) {
        if (start.equals(end))
            return true;
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        int i = 0, j = 0;
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if (i == start.length() && j == end.length()) {
                return true;
            }
            if (i == start.length() || j == end.length()) {
                return false;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j)
                return false;
            if (start.charAt(i) == 'R' && j < i)
                return false;
            i++;
            j++;
        }
        return true;
    }
}
