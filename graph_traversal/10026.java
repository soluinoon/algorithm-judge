import java.io.*;
import java.util.*;

public class Main {
    /**
     * 10026
     * 2022-12-21
     */
    static int n;
    static int[] mrow = {-1, 1, 0, 0};
    static int[] mcol = {0, 0, -1, 1};
    static char[][] table;
    static char[][] tableTemp;
    static boolean[][] visited;
    static int count1, count2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        table = new char[n + 1][n + 1];
        tableTemp = new char[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            for (int j = 1; j <= n; j++) {
                table[i][j] = temp.charAt(j - 1);
            }
        }

        initTable();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    count1++;
                    dfs(i, j, table[i][j], table);
                }
            }
        }
        System.out.print(count1);
        clearVisited();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j]) {
                    count2++;
                    dfs(i, j, tableTemp[i][j], tableTemp);
                }
            }
        }
        System.out.print(" " + count2);
    }

    public static void dfs(int row, int col, char color, char[][] table) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + mrow[i];
            int nextCol = col + mcol[i];

            if (nextRow >= 1 && nextRow <= n && nextCol >= 1 && nextCol <= n) {
                if (table[nextRow][nextCol] == color && !visited[nextRow][nextCol]) {
                    dfs(nextRow, nextCol, color, table);
                }
            }
        }
    }

    public static void initTable() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                tableTemp[i][j] = table[i][j];
                if (tableTemp[i][j] == 'G') {
                    tableTemp[i][j] = 'R';
                }
            }
        }
    }

    public static void clearVisited() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                visited[i][j] = false;
            }
        }
    }
}
