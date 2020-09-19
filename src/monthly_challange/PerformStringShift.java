package monthly_challange;

/****
 *
 *
 *
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 *
 *
 */


public class PerformStringShift {
    public static void main(String[] args) {
        PerformStringShift sol = new PerformStringShift();
        int[][] nums = {{1, 8}, {1, 4}, {1, 3}, {1, 6}, {0, 6}, {1, 4}, {0, 2}, {0, 1}};
        String s = "yisxjwry";
        //int[} nums = {0,0,1,0,0,0,1,1};
        System.out.println(sol.stringShift(s, nums));
    }

    public String stringShift(String s, int[][] shift) {

        int index = 0;
        StringBuilder res = new StringBuilder();

        for (int[] ints : shift) {
            if (ints[0] == 0) {
                index = index + ints[1];
                if (Math.abs(index) >= s.length())
                    index = index % s.length();
            } else {
                index = index - ints[1];
                if (Math.abs(index) >= s.length())
                    index = index % s.length();
            }
        }
        if (index < 0)
            index = s.length() + index;
        for (int i = index; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < index; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

}
