class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            if (nums[i - 1] == nums[i]) {
                dp[i] = dp[i - 1];
            } else if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                for (int j = 0; j < i - 1; j++) {
                    System.out.println("j = " + j + " i = " + i);
                    System.out.println("DP = " + dp[j]);
                    if (nums[j] == nums[i]) {
                        dp[i] = Math.max(dp[j], dp[i]);
                    } else if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int count = 0;
        if (max == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[0] == nums[i]) {
                    count++;
                }
            }
        } else {
            System.out.println("max = " + max);
            for (int i = 0; i < dp.length; i++) {
                int number = dp[i];
                if (number == max) {
                    for (int j = 0; j < i; j++) {
                        if (dp[j] == max || dp[j] == max - 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
