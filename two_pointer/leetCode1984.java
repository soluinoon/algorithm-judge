class Solution {
    
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int right = k - 1;
        int answer = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (nums[right] - nums[left] < answer) {
                answer = nums[right] - nums[left];
            }
            left++;
            right++;
        }
        return answer;
    }
}
