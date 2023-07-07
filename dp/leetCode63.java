class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            if (obstacleGrid[0][0] == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        int row = 0;
        int col = 0;
        dp[0][0] = 1;

        while (true) {
            if (row == 0 && col == 0) {
                dp[0][0] = 1;
            }
            else if (row == 0) {
                dp[row][col] = dp[row][col - 1];
            } else if (col == 0) {
                dp[row][col] = dp[row - 1][col];
            } else {
                dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
            }
            if (obstacleGrid[row][col] == 1) {
                dp[row][col] = 0;
            }
            col++;
            if (col == obstacleGrid[0].length) {
                col = 0;
                row++;
            }
            if (row == obstacleGrid.length) {
                break;
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
