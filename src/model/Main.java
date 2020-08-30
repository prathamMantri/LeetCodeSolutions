package model;

import leetcode.medium.Solution15;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.solution15();
    }

    void solution15() {
        Solution15 sol = new Solution15();
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum(num));
    }
}
