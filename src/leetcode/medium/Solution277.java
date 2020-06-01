package leetcode.medium;

public class Solution277 {
    static int[][] knows = {{1, 1, 1},
            {1, 1, 0},
            {0, 0, 1}};

    static boolean knows(int a, int b) {
        return knows[a][b] == 1;
    }

    public static void main(String[] args) {
        Solution277 sol = new Solution277();
        System.out.println(sol.findCelebrity(3));
    }

    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == celebrity) {
                continue;
            }
            if (knows(celebrity, i) || !knows(i, celebrity)) {
                return -1;
            }
        }
        return celebrity;
    }
}
