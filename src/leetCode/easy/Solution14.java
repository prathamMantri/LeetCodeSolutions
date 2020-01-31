package leetCode.easy;

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++)
            result = getCommonPrefix(result, strs[i]);
        return result;
    }

    private String getCommonPrefix(String word1, String word2) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++)
            if (word1.charAt(i) == word2.charAt(i))
                result.append(word1.charAt(i));
            else
                return result.toString();
        return result.toString();
    }
}
