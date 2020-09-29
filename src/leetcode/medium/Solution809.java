package leetcode.medium;

public class Solution809 {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        if (S == null || S.length() == 0) {
            return 0;
        }
        for (String word : words) {
            if (word == null || word.length() == 0) {
                continue;
            }
            if (isExpressiveWord(word, S))
                res++;
        }
        return res;
    }

    private boolean isExpressiveWord(String word, String S) {
        int i = 0, j = 0;
        while (j < S.length() && i < word.length()) {
            char w = word.charAt(i);
            char s = S.charAt(j);
            if (w == s) {
                int wSize = getLength(word, i);
                int sSize = getLength(S, j);
                if (sSize == wSize) {
                    i++;
                    j++;
                } else if (sSize < 3 || wSize > sSize) {
                    return false;
                } else {
                    i = i + wSize;
                    j = j + sSize;
                }
            } else {
                return false;
            }
        }
        return i == word.length() && j == S.length();
    }

    private int getLength(String s, int index) {
        int size = 1;
        while (index < s.length() - 1) {
            if (s.charAt(index) == s.charAt(++index))
                size++;
            else {
                break;
            }
        }
        return size;
    }
}
