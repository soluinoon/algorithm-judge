class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;

        int i = 0;
        while (i < nums.length) {
            int number = nums[i];
            int index = count;
            System.out.println("number = " + number + " index = " + i);
            count++;
            while (i < nums.length - 1 && nums[i + 1] == number) {
                i++;
            }
            i++;
            nums[index] = number;
        }
        return count;
    }
}
