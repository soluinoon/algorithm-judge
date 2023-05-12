import java.util.*;

class Solution {
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        dp = new int[triangle.length + 1][triangle.length + 1];
        dp[1][1] = triangle[0][0];
        
/*  i j
    1) 1 // 유저세팅
    2) 1(i-1의 1) 2(i-1의 i-1)
    3) 1(i-1의 1) 2(i-1의 j-1, i-1의 j중 큰것) 3(i-1의 i-1)
    4) 1 2 3 4
        */
        
        // set dp
        for (int i = 2; i <= triangle.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = triangle[i - 1][j - 1] + dp[i - 1][j];
                } else if (j == i) {
                    dp[i][j] = triangle[i - 1][j - 1] + dp[i - 1][i - 1];
                } else {
                    dp[i][j] = triangle[i - 1][j - 1]+ Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                // System.out.printf("dp[%d][%d] = %d\n", i, j, dp[i][j]);
            }
        }
        
        // find answer
        for (int i = 1; i <= triangle.length; i++) {
            if (answer < dp[triangle.length][i]) {
                answer = dp[triangle.length][i];
            }
        }
        
        return answer;
    }
}
