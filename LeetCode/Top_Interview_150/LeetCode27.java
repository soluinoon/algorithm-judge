class Solution {
    public int removeElement(int[] nums, int val) {
        int[] numsWithoutVal = new int[nums.length];
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) numsWithoutVal[result++] = nums[i];
        }
        for (int i = 0; i < result; i++) {
            nums[i] = numsWithoutVal[i];
        }
        return result;
    }
}
