package leetcode.easy;

public class Solution443 {
    public static void main(String[] args) {
        Solution443 solution = new Solution443();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'a', 'a'};
        System.out.println(solution.compress(chars));
    }

    public int compress(char[] chars) {
        int count = 1;
        char tempChar = chars[0];
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (tempChar == chars[i]) {
                count++;
                tempChar = chars[i];
            } else {
                if (count == 1) {
                    result.append(tempChar);
                } else {
                    result.append(tempChar).append(count);
                }
                tempChar = chars[i];
                count = 1;
            }
        }
        result.append(tempChar).append(count);
        return result.toString().toCharArray().length;
    }
}
