class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int len = 0; len < n; len++) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len;
                // System.out.println("left = " + left + " right = " + right);
                if (len == 0) {
                    dp[left][right] = true;
                } else if (len == 1 && s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = true;
                } else {
                    if ((s.charAt(left) == s.charAt(right)) && dp[left + 1][right - 1]) {
                        dp[left][right] = true;
                    }
                }

                if (dp[left][right] && len >= answer.length()) {
                    answer = s.substring(left, right + 1);
                    // System.out.println("Answer = " + answer);
                }
            }
        }
        return answer;
    }
}
