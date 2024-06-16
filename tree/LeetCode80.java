class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> linkedList = new LinkedList<>();

        for (int num : nums) linkedList.add(num);

        int index = 0;
        int prevNum = Integer.MIN_VALUE;
        int count = 0;
        while (index < linkedList.size()) {
            if (linkedList.get(index) == prevNum) {
                count++;
            } else {
                count = 1;
                prevNum = linkedList.get(index);
            }
            if (count > 2) {
                linkedList.remove(index);
                continue;
            }
            index++;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            nums[i] = linkedList.get(i);
        }
        return linkedList.size();
    }
}
