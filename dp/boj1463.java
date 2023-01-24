import java.io.*;
import java.util.*;

public class Main {
    /**
     * 1463 1만들기
     * https://www.acmicpc.net/problem/1463
     */
    static int[] dp = new int[1_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        // logic
        for (int i = 4; i <= n; i++) {
            if (i % 2 != 0 && i % 3 != 0) {
                dp[i] = dp[i - 1] + 1;
            } else if (i % 2 == 0 && i % 3 == 0) {
                int temp = Math.min(dp[i / 2] + 1, dp[i / 3] + 1);
                dp[i] = Math.min(temp, dp[i - 1] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i - 1] + 1);
            } else {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i - 1] + 1);
            }
            // System.out.println("dp[" + i + "] = " + dp[i]);
        }

        // get answer
        System.out.println(dp[n]);
    }
}