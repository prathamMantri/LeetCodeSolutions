package leetcode.hard;

import model.Robot;

import java.util.HashSet;
import java.util.Set;

public class Solution489 {
    public void cleanRoom(Robot robot) {
        //left,     up   right   down

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<String> visited = new HashSet<>();
        backtrack(0, 0, 0, directions, visited, robot);
    }

    private void backtrack(int row, int col, int direction, int[][] directions, Set<String> visited, Robot robot) {
        visited.add(row + "-" + col);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];

            if (!visited.contains(newRow + "-" + newCol) && robot.move()) {
                backtrack(newRow, newCol, newDirection, directions, visited, robot);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

}
