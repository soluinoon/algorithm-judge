class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];
        
        for (int i = 3; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            System.out.printf("dp[%d] = %d\n", i, dp[i]);
        }
        return Math.max(dp[nums.length - 2], dp[nums.length - 1]);
    }
}
