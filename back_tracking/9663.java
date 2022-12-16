import java.io.*;
import java.util.*;

/**
 * N-QUEEN
 * 2022-12-16
 */
class Main {
    static int[][] table;
    static boolean[][] visited;
    static int count;
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        table = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            table[1][i] = 1;
            setQueen(1, i, n - 1);
            table[1][i] = 0;
        }
        System.out.println(count);
    }

    public static void setQueen(int row, int col, int left) {
        if (!isRight(row, col)) {
            return;
        }
        if (left == 0) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            table[row + 1][i] = 1;
            setQueen(row + 1, i, left - 1);
            table[row + 1][i] = 0;
        }
    }

    public static boolean isRight(int row, int col) {
        return isHorizonOk(row, col) && isVerticalOk(row, col) && isNegativeGradientOk(row, col) && isPositiveGradientOk(row, col);
    }

    private static boolean isHorizonOk(int row, int col) {
        for (int i = 1; i <= n; i++) {
            if (i != col && table[row][i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVerticalOk(int row, int col) {
        for (int i = 1; i <= n; i++) {
            if (i != row && table[i][col] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNegativeGradientOk(int row, int col) {
        int nextRow, nextCol;

        // 왼쪽위 대각
        nextRow = row - 1;
        nextCol = col - 1;
        while (nextRow >= 1 && nextCol >= 1) {
            if (table[nextRow][nextCol] == 1) {
                return false;
            }
            nextRow--;
            nextCol--;
        }

        // 오른쪽아래 대각
        nextRow = row + 1;
        nextCol = col + 1;
        while (nextRow <= n && nextCol <= n) {
            if (table[nextRow][nextCol] == 1) {
                return false;
            }
            nextRow++;
            nextCol++;
        }
        return true;
    }

    private static boolean isPositiveGradientOk(int row, int col) {
        int nextRow, nextCol;

        // 오른쪽위 대각
        nextRow = row - 1;
        nextCol = col + 1;
        while (nextRow >= 1 && nextCol <= n) {
            if (table[nextRow][nextCol] == 1) {
                return false;
            }
            nextRow--;
            nextCol++;
        }

        // 왼쪽아래 대각
        nextRow = row + 1;
        nextCol = col - 1;
        while (nextRow <= n && nextCol >= 1) {
            if (table[nextRow][nextCol] == 1) {
                return false;
            }
            nextRow++;
            nextCol--;
        }

        return true;
    }
}