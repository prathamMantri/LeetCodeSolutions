package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n, "", new ArrayList<>());
    }

    public List<String> generateParenthesis(int openP, int closeP, String parenthesis, List<String> parenthesisList) {
        if (openP == 0 && closeP == 0)
            parenthesisList.add(parenthesis);
        if (openP > closeP)
            return null;
        if (openP > 0)
            generateParenthesis(openP - 1, closeP, parenthesis + "(", parenthesisList);
        if (closeP > 0)
            generateParenthesis(openP, closeP - 1, parenthesis + ")", parenthesisList);
        return parenthesisList;
    }
    public static void main(String[] args) {
        Solution22 sol = new Solution22();
        System.out.println(sol.generateParenthesis(10));
    }
}
