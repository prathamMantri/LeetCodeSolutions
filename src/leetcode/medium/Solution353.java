package leetcode.medium;

import java.util.LinkedList;

public class Solution353 {
    public static class SnakeGame {
        int[][] board;
        int[][] food;
        int score, foodPointer;
        LinkedList<Position> snake;

        public SnakeGame(int width, int height, int[][] food) {
            this.board = new int[height][width];
            this.food = food;
            this.foodPointer = 0;
            this.score = 0;
            snake = new LinkedList<>();
            snake.addFirst(new Position(0, 0));
        }

        /**
         * Moves the snake.
         *
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over.
         * Game over when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            Position curr = snake.getFirst();
            Position next;
            Position tail = snake.removeLast();

            if (direction.equals("U"))
                next = new Position(curr.x - 1, curr.y);
            else if (direction.equals("D"))
                next = new Position(curr.x + 1, curr.y);
            else if (direction.equals("R"))
                next = new Position(curr.x, curr.y + 1);
            else
                next = new Position(curr.x, curr.y - 1);
            //check if out of bound or it bites itself
            if (next.x < 0 || next.x == board.length || next.y < 0 || next.y == board[0].length || snake.contains(next))
                return -1;

            snake.add(next);
            if (score < food.length && next.x == food[foodPointer][0] && next.y == food[foodPointer][1]) {
                snake.addLast(tail);
                score++;
            }
            return score;
        }

        static class Position {
            int x;
            int y;

            Position(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (o == this) return true;
                if (!(o instanceof Position)) return false;
                Position p = (Position) o;
                return p.x == this.x && p.y == this.y;
            }
        }
    }
}
