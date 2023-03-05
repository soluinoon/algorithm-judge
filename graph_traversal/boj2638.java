import java.util.*;
import java.io.*;

class Main {
    /**
     * https://www.acmicpc.net/problem/2638
     * 2638 치즈
     */
    static int[][] table;
    static boolean[][] visited;
    static int[][] tableTemp;

    /// 상 하 좌 우
    static int[] mRow = {-1, 1, 0, 0};
    static int[] mCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        table = new int[row][col];
        tableTemp = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        table[0][0] = -1;
        while (!isEnd()) {
            time++;
            bfs(row, col);
            melt();
        }
        System.out.println(time);
    }

    private static void bfs(int row, int col) {
        Deque<int []> dq = new LinkedList<>();

        visited = new boolean[row][col];
        dq.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = cur[0] + mRow[i];
                int nextCol = cur[1] + mCol[i];

                if (validate(nextRow, nextCol) && !visited[nextRow][nextCol] && table[nextRow][nextCol] != 1) {
                    visited[nextRow][nextCol] = true;
                    table[nextRow][nextCol] = -1;
                    dq.add(new int[] {nextRow, nextCol});
                }
            }
        }
    }

    private static boolean validate(int row, int col) {
        return row >= 0 && col >= 0 && row < table.length && col < table[0].length;
    }

    private static void melt() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1 && isMelt(i, j)) {
                    table[i][j] = 0;
                }
            }
        }
    }

    private static boolean isMelt(int row, int col) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + mRow[i];
            int nextCol = col + mCol[i];

            if (validate(nextRow, nextCol) && table[nextRow][nextCol] == -1) {
                count++;
            }
        }
        return count >= 2;
    }

    private static boolean isEnd() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
