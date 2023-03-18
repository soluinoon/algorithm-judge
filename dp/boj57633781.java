import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] dp = new int[101][100_001];
    static int[][] item;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        // {weight, value}
        item = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            item[i][0] = weight;
            item[i][1] = value;
        }

        // logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i- 1][j];
                if (item[i][0] <= j) {
                    int temp1 = dp[i - 1][j - item[i][0]] + item[i][1];
                    dp[i][j] = Math.max(dp[i - 1][j], temp1);
                }
            }
        }

        System.out.println(dp[n][capacity]);
    }
}
