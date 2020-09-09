package model;

import leetcode.easy.Solution1470;
import leetcode.easy.Solution448;
import leetcode.easy.Solution605;
import leetcode.easy.Solution914;
import leetcode.medium.Solution15;
import leetcode.medium.Solution442;
import leetcode.medium.Solution62;
import leetcode.medium.Solution63;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        /*main.solution15();
        main.solution62();
        main.solution63();
        main.solution1470();
        main.solution914();*/
        main.solution605();
    }

    void solution15() {
        Solution15 sol = new Solution15();
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum(num));
    }

    void solution1470() {
        Solution1470 sol = new Solution1470();
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(sol.shuffle(num, 3)));
    }

    void solution442() {
        Solution442 sol = new Solution442();
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(sol.findDuplicates(num));
    }

    void solution448() {
        Solution448 sol = new Solution448();
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(sol.findDisappearedNumbers(num));
    }

    void solution605() {
        Solution605 sol = new Solution605();
        int[] num = {1, 0, 0, 0, 1};
        System.out.println(sol.canPlaceFlowers(num, 1));
    }

    void solution914() {
        Solution914 sol = new Solution914();
        int[] num = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(sol.hasGroupsSizeX(num));
    }

    void solution62() {
        Solution62 sol = new Solution62();
        int m = 4, n = 4;
        System.out.println(sol.uniquePaths(m, n));
    }

    void solution63() {
        Solution63 sol = new Solution63();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
    }
}
