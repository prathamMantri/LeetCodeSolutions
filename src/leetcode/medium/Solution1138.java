package leetcode.medium;

public class Solution1138 {
    StringBuilder res = new StringBuilder();

    public String alphabetBoardPath(String target) {
        int currRow = 0;
        int currCol = 0;
        for (int i = 0; i < target.length(); i++) {
            int pos = target.charAt(i) - 'a';
            int targetRow = pos / 5;
            int targetCol = pos % 5;
            res.append(buildPath(currRow, currCol, targetRow, targetCol));
            currRow = targetRow;
            currCol = targetCol;
        }
        return res.toString();
    }

    String buildPath(int currRow, int currCol, int targetRow, int targetCol) {
        char verDirection = currRow > targetRow ? 'U' : 'D';
        char horDirection = currCol > targetCol ? 'L' : 'R';
        StringBuilder horMoves = new StringBuilder();
        for (int i = 0; i < Math.abs(currCol - targetCol); i++) {
            horMoves.append(horDirection);
        }
        StringBuilder verMoves = new StringBuilder();
        for (int i = 0; i < Math.abs(currRow - targetRow); i++) {
            verMoves.append(verDirection);
        }
        return horDirection == 'R' ? verMoves.append(horMoves).append('!').toString() : horMoves.append(verMoves).append('!').toString();
    }
}
