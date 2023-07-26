class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        /*
        
        0 3,2 
        1 4,3
        2 4,4
        3 2,5 
        (4) 0 0 
        
        */

        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            long pick;
            if (questions[i][1] + i + 1 < n) {
                pick = questions[i][0] + dp[questions[i][1] + i + 1];
            } else {
                pick = questions[i][0];
            }
            long notPick = dp[i + 1]; 
            dp[i] = Math.max(pick, notPick);
            // System.out.printf("dp[%d]=%d\n", i, dp[i]);
        }
        return dp[0];
    }
}
