package leetcode.easy;

public class Solution953 {
    public static void main(String[] args) {

        String[] words = {"kuvp", "q"};
        String orders = "ngxlkthsjuoqcpavbfdermiywz";

        Solution953 sol = new Solution953();
        System.out.println(sol.isAlienSorted(words, orders));
    }

    public boolean isAlienSorted(String[] words, String order) {

        Boolean res = true;
        if (words.length == 2) {
            return compare(words[0], words[1], order);
        }

        for (int i = 0; i <= words.length - 2; i++) {
            if (res)
                res = compare(words[i], words[i + 1], order);
            else
                return false;
        }
        return res;
    }

    public boolean compare(String s1, String s2, String order) {
        int i = 0, j = 0, index1, index2;

        while (i < s1.length() && i < s2.length()) {
            index1 = order.indexOf(s1.charAt(i));
            index2 = order.indexOf(s2.charAt(j));
            if (index1 == index2) {
                i++;
                j++;
            } else return index1 <= index2;
        }
        return s1.length() < s2.length();
    }

}
