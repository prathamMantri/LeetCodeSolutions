package leetcode.easy;

public class Solution482 {
    public String licenseKeyFormatting(String S, int K) {

        if (S == null || S.length() == 0 || K == 0) {
            return "";
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '-') {
                continue;
            }
            count++;
        }
        int remainder = count % K;
        int group = K;
        StringBuilder sb = new StringBuilder();
        char c;
        int i = 0;
        if (remainder != 0) {
            while (remainder > 0) {
                c = S.charAt(i++);
                if (c == '-') {
                    continue;
                }
                sb.append(c);
                remainder--;
            }
            sb.append('-');
        }

        while (i < S.length()) {
            c = S.charAt(i++);
            if (c == '-') {
                continue;
            }
            if (group > 0) {
                sb.append(c);
                group--;
            } else {
                i--;
                sb.append('-');
                group = K;
            }
        }

        return sb.toString().toUpperCase();
    }
}
