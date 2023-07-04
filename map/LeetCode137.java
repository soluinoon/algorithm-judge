class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count + 1 == 3) {
                map.remove(num);
            } else {
                map.put(num, count + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }
}
