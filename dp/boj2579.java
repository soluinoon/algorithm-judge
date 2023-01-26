import java.io.*;
import java.util.*;

public class Main {
    /**
     * https://www.acmicpc.net/problem/2579
     * 2579 계단 오르기
     * start    10:14
     * end
     */
    static int[] stairs;
    static int[] dp = new int[301];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // input
//        stairs = new int[n + 1];
        stairs = new int[301];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);

        // logic
        for (int i = 4; i <= n; i++) {
            dp[i] = stairs[i] + Math.max(stairs[i - 1] + dp[i - 3], dp[i - 2]);
        }
        System.out.println(dp[n]);
    }
}