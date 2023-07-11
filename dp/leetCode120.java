class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int side = triangle.size();
        int[][] dp = new int[side][side];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currentLine = triangle.get(i);
            for (int j = 0; j < currentLine.size(); j++) {
                if (j == 0) {
                    dp[i][j] = currentLine.get(j) + dp[i - 1][j];
                } else if (j == currentLine.size() - 1) {
                    dp[i][j] = currentLine.get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = currentLine.get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < side; i++) {
            if (dp[side - 1][i] < answer) {
                answer = dp[side - 1][i];
            }
        }
        return answer;
    }
}
