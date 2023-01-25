import java.io.*;
import java.util.*;

public class Main {
    /**
     * https://www.acmicpc.net/problem/1149
     * 1149 RGB 거리
     * start    09:37
     * end      09:57
     */
    static int[][] colors;
    static int[][] dp = new int[1001][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // input
        colors = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        dp[1][1] = colors[1][1];
        dp[1][2] = colors[1][2];
        dp[1][3] = colors[1][3];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = colors[i][1] + Math.min(dp[i - 1][2], dp[i - 1][3]);
            dp[i][2] = colors[i][2] + Math.min(dp[i - 1][1], dp[i - 1][3]);
            dp[i][3] = colors[i][3] + Math.min(dp[i - 1][1], dp[i - 1][2]);
        }

        int temp = Math.min(dp[n][1], dp[n][2]);
        System.out.println(Math.min(temp, dp[n][3]));
    }
}