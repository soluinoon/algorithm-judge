import java.io.*;
import java.util.*;

class Main {
    static int[][] table;
    // 상 하 좌 우
    static int[] mRow = {-1, 1, 0, 0};
    static int[] mCol = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        table = new int[rowSize][colSize];

        // input
        for (int i = 0; i < rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        dfs(0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int row, int col, int count) {
        if (count == 3) {
            int[][] tableCopy = copyTable(table);
            int safeAreaSize = getSafeAreaSize(tableCopy);
            if (max < safeAreaSize) {
                max = safeAreaSize;
            }
            return;
        }
        if (col == table[0].length) {
            col = 0;
            row++;
        }
        while (true) {
            if (row == table.length && col == 0) {
                break;
            }
            if (table[row][col] == 0) {
                table[row][col] = 1;
                dfs(row, col + 1, count + 1);
                table[row][col] = 0;
            }
            col++;
            if (col == table[0].length) {
                col = 0;
                row++;
            }
        }
    }

    private static int[][] copyTable(int[][] table) {
        int[][] tableCopy = new int[table.length][table[0].length];
        for (int i = 0; i < table.length; i++) {
            tableCopy[i] = table[i].clone();
        }
        return tableCopy;
    }

    private static int getSafeAreaSize(int[][] tableCopy) {
        for (int i = 0; i < tableCopy.length; i++) {
            for (int j = 0; j < tableCopy[0].length; j++) {
                if (tableCopy[i][j] == 2) {
                    spread(tableCopy, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < tableCopy.length; i++) {
            for (int j = 0; j < tableCopy[0].length; j++) {
                if (tableCopy[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void spread(int[][] table, int row, int col) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {row, col});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + mRow[i];
                int nextCol = curCol + mCol[i];

                if (isInRange(table, nextRow, nextCol) && (table[nextRow][nextCol] == 0 || table[nextRow][nextCol] == 2)) {
                    table[nextRow][nextCol] = 3;
                    q.add(new int[] {nextRow, nextCol});
                }
            }
        }
    }

    private static boolean isInRange(int[][] table, int row, int col) {
        return row >= 0 && col >= 0 && row < table.length && col < table[0].length;
    }
}
