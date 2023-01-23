import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1932 정수 삼각형
     * https://www.acmicpc.net/problem/1932
     * 시작 18:42
     * 끝 18:53
     */
    static int[][] dp = new int[501][501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp[1][1] = Integer.parseInt(br.readLine());
        // logic
        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][1] = Integer.parseInt(st.nextToken()) + dp[i - 1][1];
                } else {
                    int temp = Integer.parseInt(st.nextToken());
                    dp[i][j] = temp + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        // get answer
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[n][i] > answer) {
                answer = dp[n][i];
            }
        }
        System.out.println(answer);
    }
}