import java.io.*;
import java.util.*;

/*
 * 9663 N - QUEEN
 * 
 */

public class Main {

    static int n;
    static int list[][];
    static int queen[];

    static int res;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        n = Integer.parseInt(br.readLine());

        list = new int[n][n];
        queen = new int[n];

        // excute;
        for ()

    }

    public void setQueen() {
        
    }
    public static void listSetZero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = 0;
            }
        }
    }

    public static void checkVaild() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (list[i][j] == 1) {
                    if (checkGredientMinus(i, j) == 0)
                        return;
                    if (checkGredientPlus(i, j) == 0)
                        return;
                }
            }
        }
        res++;
    }

    public static int checkGredientMinus(int row, int col) {
        // up
        int rowTemp = row;
        int colTemp = col;
        while (true) {
            rowTemp--;
            colTemp--;
            if (rowTemp < 0 || colTemp < 0)
                break;
            if (list[rowTemp][colTemp] == 1)
                return 0;
        }
        // down
        rowTemp = row;
        colTemp = col;
        while (true) {
            rowTemp++;
            colTemp++;
            if (rowTemp < 0 || colTemp < 0)
                break;
            if (list[rowTemp][colTemp] == 1)
                return 0;
        }
        return 1;
    }

    public static int checkGredientPlus(int row, int col) {
        // up
        int rowTemp = row;
        int colTemp = col;
        while (true) {
            rowTemp--;
            colTemp++;
            if (rowTemp < 0 || colTemp >= n)
                break;
            if (list[rowTemp][colTemp] == 1)
                return 0;
        }
        // down
        rowTemp = row;
        colTemp = col;
        while (true) {
            rowTemp++;
            colTemp--;
            if (rowTemp >= n || colTemp < 0)
                break;
            if (list[rowTemp][colTemp] == 1)
                return 0;
        }
        return 1;
    }
}