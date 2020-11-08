package leetcode.medium;

public class Solution6 {
    public String convert1(String s, int numRows) {
        int n = s.length(), i = 0, j = 0, k = 0;
        boolean goDown = true;
        char[][] zigzag = new char[n][numRows];
        StringBuilder zigzagString = new StringBuilder();
        while (k < n) {
            zigzag[i][j] = s.charAt(k);
            if (goDown) {
                j++;
                if (j == numRows - 1) {
                    goDown = false;
                }
            } else {
                j--;
                i++;
                if (j == 0) {
                    goDown = true;
                }
            }
            k++;
        }
        for (int p = 0; p < numRows; p++)
            for (int q = 0; q < n; q++)
                zigzagString.append(zigzag[q][p]);

        return zigzagString.toString();
    }

    public String convert(String s, int numRows) {
        if (s.equals("") || numRows < 2) {
            return s;
        }
        // i for cols
        // j for rows
        // k for looping on strings
        int n = s.length(), i = 0, j = 0, k = 0;
        boolean goUp = false;
        Character[][] zigzag = new Character[n][numRows];
        for (int p = 0; p < numRows; p++)
            for (int q = 0; q < n; q++)
                zigzag[q][p] = ' ';
        StringBuilder zigzagString = new StringBuilder();
        while (k < n) {
            while (!goUp && k < n) {
                zigzag[i][j++] = s.charAt(k++);
                goUp = j == numRows;
            }
            while (goUp && k < n) {
                zigzag[++i][--j] = s.charAt(k++);
                goUp = j > 0;
            }
        }
        for (int p = 0; p < numRows; p++)
            for (int q = 0; q < n; q++)
                zigzagString.append(zigzag[q][p] == ' ' ? "" : zigzag[q][p]);

        return zigzagString.toString();
    }

    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        System.out.println(sol.convert("PAYPALISHIRING", 3));
    }

}
