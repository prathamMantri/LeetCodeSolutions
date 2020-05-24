package leetcode.medium;

public class Solution151 {

    public static void main(String[] args) {
        Solution151 sol = new Solution151();
        System.out.println(sol.reverseWords("a good   example"));
    }

    public String reverseWords(String s) {
        if (s.equals("") || s == null) {
            return "";
        }

        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = sArr.length - 1; i >= 0; i--) {

            sb.append(sArr[i]).append(sArr[i].equals("") ? "" : " ");

        }

        return sb.toString().trim();

    }


}
