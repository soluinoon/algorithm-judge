import java.io.*;
import java.util.*;

public class Main {
    /**
     * 2023-01-15
     * https://www.acmicpc.net/problem/1912
     * 1912 연속합
     */
    static long[] dp = new long[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (i == 1) {
                dp[i] = number;
            } else {
                dp[i] = Math.max(dp[i - 1] + number, number);
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}