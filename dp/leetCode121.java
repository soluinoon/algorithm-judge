class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 1];
        int answer = 0;

        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            if (prices[i] - dp[i] > answer) {
                answer = prices[i] - dp[i];
            }
        }
        return answer;
    }
}
