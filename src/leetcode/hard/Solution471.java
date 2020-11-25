package leetcode.hard;

public class Solution471 {
    /*static Map<String, String> prevResults = new HashMap<>();
    public String encode(String s) {
        if (s == null || s.length() < 5) {
            return s;
        }
        if (prevResults.containsKey(s)) {
            return prevResults.get(s);
        }
        int strlen = s.length();
        int minLength = Integer.MAX_VALUE;
        String choosenString = s;
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            String encodedString = s;
            // split the string at index i into 2 strings
            String leftStr = s.substring(0, i);
            String rightStr = s.substring(i, strlen);
            int repeatCounter = findPrefixRepetitions(leftStr, rightStr);
            if (repeatCounter > 0) {
                encodedString = "" + (repeatCounter + 1) + '[' + encode(leftStr) + ']' + encode(rightStr.substring(repeatCounter * leftStr.length()));
            }
            String encodedString2 = encode(leftStr) + encode(rightStr);
            if (encodedString2.length() < encodedString.length()) {
                encodedString = encodedString2;
            }
            if (encodedString.length() < strlen) {
                if (minLength > encodedString.length()) {
                    choosenString = encodedString;
                    minLength = encodedString.length();
                }
            }
        }
        prevResults.put(s, choosenString);
        return choosenString;
    }
    private int findPrefixRepetitions(String prefix, String str) {
        int repeatCounter = 0;
        int startIndex = 0;
        do {
            int prefixIndex = str.indexOf(prefix, startIndex);
            if (prefixIndex != startIndex) {
                break;
            }
            repeatCounter++;
            startIndex = prefixIndex + prefix.length();
        } while (startIndex < str.length());
        return repeatCounter;
    }*/

    public String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                String current = s.substring(i, j + 1);
                dp[i][j] = current;
                if (current.length() > 4) {
                    // Try all possible splits
                    for (int k = i; k < j; k++) {
                        String left = dp[i][k];
                        String right = dp[k + 1][j];
                        if (left.length() + right.length() < dp[i][j].length()) {
                            dp[i][j] = left + right;
                        }
                    }
                    // try to compress the string
                    for (int k = 0; k < current.length(); k++) {
                        String pattern = current.substring(0, k + 1);
                        if (current.length() % pattern.length() == 0 && current.replace(pattern, "").equals("")) {
                            String candidate = current.length() / pattern.length() + '[' + dp[i][k] + ']';
                            if (candidate.length() < dp[i][j].length())
                                dp[i][j] = candidate;
                        }
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
