import java.io.*;
import java.util.*;

public class Main {
    /**
     * https://www.acmicpc.net/problem/2579
     * 2156     포도주 시식
     * start    18:32
     * end
     */
    static int[] wines;
    static int[] dp = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        wines = new int[10001];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        int temp = Math.max(wines[1] + wines[2], wines[1] + wines[3]);
        dp[3] = Math.max(temp, wines[2] + wines[3]);

        System.out.println("dp1 " + dp[1]);
        System.out.println("dp2 " + dp[2]);
        System.out.println("dp3 " + dp[3]);

        int max = Integer.MIN_VALUE;
        // logic
        for (int i = 4; i <= n; i++) {
            System.out.println("wines[" + i + "] = " + wines[i]);
            System.out.print("i = " + i + " ");
            dp[i] = Math.max(wines[i] + Math.max(dp[i - 3] + wines[i - 1], dp[i - 2]), dp[i - 1]);
            System.out.println("dp = " + dp[i]);
        }
        System.out.println(dp[n]);
    }
}