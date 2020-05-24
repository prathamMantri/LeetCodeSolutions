package leetcode.medium;

public class Solution75 {
    public static void main(String[] args) {
        Solution75 sol = new Solution75();
        System.out.println(sol.solution("SMS"));
    }

    private String solution(String T) {

        int S = 0, M = 0, L = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == 'S') {
                S++;
            } else if (T.charAt(i) == 'M') {
                M++;
            } else {
                L++;
            }
        }
        while (S > 0) {
            res.append('S');
            S--;
        }
        while (M > 0) {
            res.append('M');
            M--;
        }
        while (L > 0) {
            res.append('L');
            L--;
        }
        return res.toString();
    }


}

