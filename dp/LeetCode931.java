class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = getPrevMinDp(dp, i, j) + matrix[i][j];
            }
            print(dp[i]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            if (answer > dp[matrix.length - 1][i]) {
                answer = dp[matrix.length - 1][i];
            }
        }
        return answer;
    }

    private int getPrevMinDp(int[][] dp, int row, int col) {
        int min = dp[row - 1][col];

        if (col - 1 >= 0 && dp[row - 1][col - 1] < min) {
            min = dp[row - 1][col - 1];
        } 
        if (col + 1 < dp[0].length && dp[row - 1][col + 1] < min) {
            min = dp[row - 1][col + 1];
        }
        return min;
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
