import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int [][] table = new int[size + 1][4];
        int [][] dp = new int[size + 1][4];

        StringTokenizer st;
        for (int i = 1; i <= size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                 table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = table[1][1];
        dp[1][2] = table[1][2];
        dp[1][3] = table[1][3];

        for (int i = 2; i <= size; i++) {
            dp[i][1] = table[i][1] + Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = table[i][2] + Math.max(Math.max(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][3] = table[i][3] + Math.max(dp[i - 1][2], dp[i - 1][3]);
        }

        System.out.print(Math.max(Math.max(dp[size][1], dp[size][2]), dp[size][3]));

        for (int i = 2; i <= size; i++) {
            dp[i][1] = table[i][1] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = table[i][2] + Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), dp[i - 1][3]);
            dp[i][3] = table[i][3] + Math.min(dp[i - 1][2], dp[i - 1][3]);
        }
        System.out.print(" " + Math.min(Math.min(dp[size][1], dp[size][2]), dp[size][3]));
    }
}
