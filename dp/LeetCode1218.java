class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int answer = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int prevDp = map.getOrDefault(arr[i] - difference, 0);

            map.put(arr[i], prevDp + 1);
            answer = Math.max(answer, prevDp + 1);
        }
        return answer;
    }
}
