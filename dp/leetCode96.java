class Solution {
    public int numTrees(int n) {
        // dp = g
        int[] dp = new int[n + 1];
        int answer = 0;
        dp[0] = 1;
        dp[1] = 1;

        // set root node
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
