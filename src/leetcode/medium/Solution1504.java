package leetcode.medium;

public class Solution1504 {
    /*public int numSubmat(int[][] mat) {

        int[][] dp = new int[mat.length + 1][mat[0].length + 1];

        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (mat[i - 1][j - 1] == 0) dp[i][j] = 0;
                else dp[i][j] = dp[i][j-1] + mat[i-1][j-1];

        for (int i = 0; i < dp.length; i++) {
            System.out.println("");
            for (int j = 0; j < dp[0].length; j++){
                System.out.print("    "+dp[i][j]);
            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (mat[i - 1][j - 1] == 0) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println("");
            for (int j = 0; j < dp[0].length; j++){
                System.out.print("    "+dp[i][j]);
            }
        }


        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                ans = ans + dp[i][j];
            }
        }

        return ans;
    }*/

    public int numSubmat(int[][] mat) {

        int ans = 0;
        //Suming for each column
        for (int i = 1; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 1) mat[i][j] = mat[i - 1][j] + 1;


        //Calculate the result row by row at each mat where val > 0
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] > 0) {
                    int min = mat[i][j];
                    ans = ans + min;
                    for (int k = j + 1; k < mat[0].length; k++) {
                        if (mat[i][k] == 0) break;
                        min = Math.min(mat[i][k], min);
                        ans = ans + min;
                    }
                }

        return ans;
    }


}
