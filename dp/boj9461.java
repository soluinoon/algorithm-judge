import java.io.*;
import java.util.*;

public class Main {
    /**
     * 2023-01-15
     * https://www.acmicpc.net/problem/9461
     * 9461 파도반 수열
     * 시작 시간 06:30
     * 완료 시간 06:39
     */
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;

        for (int i = 11; i < 101; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            System.out.println(dp[number]);
        }
    }
}