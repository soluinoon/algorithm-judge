import java.io.*;
import java.util.*;

class Main {
    /**
     * 2775
     * 부녀회장이 될테야
     * 22-12-29
     */

    static int testcase, row, col;
    static int row_mem = 1;
    static int col_mem = 1;
    static int[][] dp = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }

        // input & logic
        for (int i = 0; i < testcase; i++) {
            row = Integer.parseInt(br.readLine());
            col = Integer.parseInt(br.readLine());

            if (dp[row][col] != 0) {
                System.out.println(dp[row][col]);
                continue;
            }

            int cur_row = row_mem;
            int cur_col = col_mem;

            while (cur_row < 15) {
                if (cur_col == 15) {
                    cur_row++;
                    cur_col = 1;
                }
                dp[cur_row][cur_col] = getDp(cur_row, cur_col);
                if (cur_row == row && cur_col == col) {
                    System.out.println(dp[cur_row][cur_col]);
                    row_mem = cur_row;
                    col_mem = cur_col;
                    break;
                }
                cur_col++;
            }
        }
    }

    public static int getDp(int row, int col) {
        int res = 0;
        for (int i = 1; i <= col; i++) {
            res += dp[row - 1][i];
        }
        // System.out.println("get dp" + "(" + row + "," + col + ")=" + res);
        return res;
    }
}