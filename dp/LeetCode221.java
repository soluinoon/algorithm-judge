class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int answer = 0;

        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            answer = Math.max(answer, dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = Character.getNumericValue(matrix[0][i]);
            answer = Math.max(answer, dp[0][i]);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1' && i != 0 && j != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                    dp[i][j] += 1;
                    answer = Math.max(answer, dp[i][j]);
                }
                // System.out.printf("dp[%d][%d] = %d\n", i, j, dp[i][j]);
            }
        }
        return answer * answer;
    }
}
