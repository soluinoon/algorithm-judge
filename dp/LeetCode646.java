class Solution {
    public int findLongestChain(int[][] pairs) {
        int dp[] = new int[pairs.length];
        
        Arrays.sort(pairs, (o1, o2) -> {
            return (o1[0] - o2[0]);
        });

        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            int[] cur = pairs[i];
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                int[] prev = pairs[j];

                if (prev[1] < cur[0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[pairs.length - 1];
    }
}
