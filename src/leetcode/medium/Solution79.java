package leetcode.medium;

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && findChar(word, i, j, board, 0))
                    return true;
            }
        }
        return false;
    }

    boolean findChar(String word, int x, int y, char[][] board, int index) {

        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '*';

        if (findChar(word, x + 1, y, board, index + 1) ||
                findChar(word, x, y + 1, board, index + 1) ||
                findChar(word, x - 1, y, board, index + 1) ||
                findChar(word, x, y - 1, board, index + 1)) {
            return true;
        }
        board[x][y] = temp;
        return false;
    }

}
