class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            sb.setLength(0);
            for (int j = i; j < s.length(); j++) {
                if (sb.indexOf(Character.toString(s.charAt(j))) != -1) {
                    if (sb.length() > answer) {
                        answer = sb.length();
                        // break;
                        System.out.printf("when i = %d, j = %d, length = %d\n", i, j, sb.length());
                    }
                    break;
                } else {
                    sb.append(s.charAt(j));
                }
                if (j == s.length() - 1) {
                    if (sb.length() > answer) {
                        System.out.printf("when i = %d, j = %d, length = %d\n", i, j, sb.length());

                        answer = sb.length();
                    }
                }
            }
        }
        return answer;
    }
}
