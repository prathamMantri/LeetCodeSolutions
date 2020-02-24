package leetcode.medium;

public class Solution529 {
    public static void main(String[] args) {

        char[][] board = {
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
                {'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'},
                {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'}};

        int[] click = {0, 0};

        Solution529 sol = new Solution529();

        sol.updateBoard(board, click);
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j] + " ");
        }
    }

    /**
     * !!!!!!!Minesweeper Game!!!!!!!
     * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
     * <p>
     * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
     * <p>
     * If a mine ('M') is revealed, then the game is over - change it to 'X'.
     * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
     * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
     * Return the board when no more squares will be revealed.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * <p>
     * [['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'M', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E'],
     * ['E', 'E', 'E', 'E', 'E']]
     * <p>
     * Click : [3,0]
     * <p>
     * Output:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * Example 2:
     * <p>
     * Input:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'M', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * Click : [1,2]
     * <p>
     * Output:
     * <p>
     * [['B', '1', 'E', '1', 'B'],
     * ['B', '1', 'X', '1', 'B'],
     * ['B', '1', '1', '1', 'B'],
     * ['B', 'B', 'B', 'B', 'B']]
     * <p>
     * Note:
     * <p>
     * The range of the input matrix's height and width is [1,50].
     * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
     * The input board won't be a stage when game is over (some mines have been revealed).
     * For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0];
        int c = click[1];
        // M means unrevealed mine
        if (board[r][c] == 'M') {
            //X means revealed mine, just end the game by returning board.
            board[r][c] = 'X';
            return board;
        } else {
            if (board[r][c] == 'E') {
                findE(board, r, c);
            }
        }
        return board;
    }

    private void findE(char[][] board, int r, int c) {
        int row = board.length;
        int col = board[0].length;
        int hasMine = calcMine(board, r, c);
        if (hasMine == 0) {
            board[r][c] = 'B';
            if (r + 1 < row && board[r + 1][c] == 'E') {
                findE(board, r + 1, c);
            }
            if (r + 1 < row && c + 1 < col && board[r + 1][c + 1] == 'E') {
                findE(board, r + 1, c + 1);
            }
            if (r - 1 >= 0 && board[r - 1][c] == 'E') {
                findE(board, r - 1, c);
            }
            if (r - 1 >= 0 && c - 1 >= 0 && board[r - 1][c - 1] == 'E') {
                findE(board, r - 1, c);
            }
            if (c + 1 < col && board[r][c + 1] == 'E') {
                findE(board, r, c + 1);
            }
            if (c + 1 < col && r - 1 >= 0 && board[r - 1][c + 1] == 'E') {
                findE(board, r - 1, c + 1);
            }
            if (c - 1 >= 0 && board[r][c - 1] == 'E') {
                findE(board, r, c - 1);
            }
            if (c - 1 >= 0 && r + 1 < row && board[r + 1][c - 1] == 'E') {
                findE(board, r + 1, c - 1);
            }
        } else {
            board[r][c] = (char) (hasMine + '0');
        }
    }

    private int calcMine(char[][] board, int r, int c) {

        int row = board.length;
        int col = board[0].length;
        int mine = 0;

        if (r + 1 < row && board[r + 1][c] == 'M') {
            mine++;
        }
        if (r + 1 < row && c + 1 < col && board[r + 1][c + 1] == 'M') {
            mine++;
        }
        if (r - 1 >= 0 && board[r - 1][c] == 'M') {
            mine++;
        }
        if (r - 1 >= 0 && c - 1 >= 0 && board[r - 1][c - 1] == 'M') {
            mine++;
        }
        if (c + 1 < col && board[r][c + 1] == 'M') {
            mine++;
        }
        if (c + 1 < col && r - 1 >= 0 && board[r - 1][c + 1] == 'M') {
            mine++;
        }
        if (c - 1 >= 0 && board[r][c - 1] == 'M') {
            mine++;
        }
        if (c - 1 >= 0 && r + 1 < row && board[r + 1][c - 1] == 'M') {
            mine++;
        }
        return mine;
    }

}
