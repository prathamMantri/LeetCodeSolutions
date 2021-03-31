package codeSignal;

public class CodeWriting {

    public static void main(String[] args) {
        CodeWriting m = new CodeWriting();
        m.mergeStrings("dce", "cccbd");
    }

    String mergeStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i++));
                j++;
            } else if (s1.charAt(i) < s2.charAt(j)) {
                sb.append(s1.charAt(i++));
            } else {
                sb.append(s2.charAt(j++));
            }
        }
        while (i < s1.length()) {
            sb.append(s1.charAt(i++));
        }
        while (j < s2.length()) {
            sb.append(s2.charAt(j++));
        }
        return sb.toString();
    }


}
