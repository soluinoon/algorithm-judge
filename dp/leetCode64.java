class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        int row = 1;
        int col = 1;
        dp[0][1] = 0;

        while (true) {
            if (col == 1 && row != 1) {
                dp[row][col] = grid[row - 1][col - 1] + dp[row - 1][col];
            } else if (row == 1 && col != 1) {
                dp[row][col] = grid[row - 1][col - 1] + dp[row][col - 1];
            } else {
                dp[row][col] = grid[row - 1][col - 1] + Math.min(dp[row - 1][col], dp[row][col - 1]);
            }
            System.out.printf("dp[%d][%d] = %d\n", row, col, dp[row][col]);
            col++;
            if (col == grid[0].length + 1) {
                col = 1;
                row++;
            }
            if (row == grid.length + 1) {
                break;
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
