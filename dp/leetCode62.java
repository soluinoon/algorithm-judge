class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[0][1] = 1;
        int row = 1;
        int col = 1;

        while (true) {
            dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            col++;
            if (col == n + 1) {
                col = 1;
                row++;
            }
            if (row == m + 1) {
                break;
            }
        }
        return dp[m][n];
    }
}
