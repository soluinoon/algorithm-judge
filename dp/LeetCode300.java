class Solution {
    public int lengthOfLIS(int[] nums) {
        int peekIndex = 0;
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[peekIndex]) {
                dp[peekIndex + 1] = nums[i];
                peekIndex++;
            } else {
                int index = getLowerBound(dp, 0, peekIndex, nums[i]);
                dp[index] = nums[i];
            }
            // print(dp, peekIndex);
        }

        return peekIndex + 1;
    }

    private int getLowerBound(int[] dp, int left, int right, int number) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (dp[mid] < number) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private void print(int[] dp, int peekIndex) {
        System.out.print("dp = ");
        for (int i = 0; i <= peekIndex; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
