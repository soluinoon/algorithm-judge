import java.io.*;
import java.util.*;

// 2630
// 색종이 접기

public class Main {

    static int n;
    static int list[][];
    static int blue, white;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        n = Integer.parseInt(br.readLine());

        list = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(list, 0, n - 1, 0, n - 1);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void cut(int[][] table, int rowStart, int rowEnd, int colStart, int colEnd) {
        int edge = rowEnd - rowStart + 1;
        int halfEdge = edge / 2;

        if (edge == 1 || isAllSameColor(table, rowStart, rowEnd, colStart, colEnd) == true) {
            if (table[rowStart][colStart] == 1)
                blue++;
            else
                white++;
            return;
        }

        
        /*
         * 2 1
         * 3 4
         */

        checkTwoArea(table, rowStart, rowEnd, colStart, colEnd);
        checkOneArea(table, rowStart, rowEnd, colStart, colEnd);
        checkThreeArea(table, rowStart, rowEnd, colStart, colEnd);
        checkFourArea(table, rowStart, rowEnd, colStart, colEnd);

        
    }

    public static boolean isAllSameColor(int[][] table, int rowStart, int rowEnd, int colStart, int colEnd) {

        int color = table[rowStart][colStart];

        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                if (table[i][j] != color)
                    return false;
            }
        }
        return true;
    }


    public static void checkTwoArea(int[][] table, int rowStart, int rowEnd, int colStart, int colEnd) {

        int edge = rowEnd - rowStart + 1;
        int halfEdge = edge / 2;

        int color = list[rowStart][colStart];
        for (int i = rowStart; i < rowStart + halfEdge; i++) {
            for (int j = colStart; j < colStart + halfEdge; j++) {
                if (list[i][j] != color) {
                    cut(table, rowStart, rowStart + halfEdge - 1, colStart, colStart + halfEdge - 1);
                    return;
                }
            }
        }
        // System.out.println("row " + rowStart + "~" + rowEnd);
        // System.out.println("col " + colStart + "~" + colEnd);
        // System.out.println("TwoAreaFinish");

        if (color == 1) {
            // System.out.println("res = blue");
            blue++;
        } else {
            // System.out.println("res = white");
            white++;
        }
        // System.out.println();
    }

    public static void checkOneArea(int[][] table, int rowStart, int rowEnd, int colStart, int colEnd) {

        int edge = rowEnd - rowStart + 1;
        int halfEdge = edge / 2;

        int color = list[rowStart][colStart + halfEdge];
        for (int i = rowStart; i < rowStart + halfEdge; i++) {
            for (int j = colStart + halfEdge; j <= colEnd; j++) {
                if (list[i][j] != color) {
                    cut(table, rowStart, rowStart + halfEdge - 1, colStart + halfEdge, colEnd);
                    return;
                }
                    
            }
        }
        // System.out.println("row " + rowStart + "~" + rowEnd);
        // System.out.println("col " + colStart + "~" + colEnd);
        // System.out.println("OneAreaFinish");
        if (color == 1) {
            // System.out.println("res = blue");
            blue++;
        } else {
            //System.out.println("res = white");
            white++;
        }
        //System.out.println();
    }

    public static void checkThreeArea(int[][] table, int rowStart, int rowEnd, int colStart, int colEnd) {

        int edge = rowEnd - rowStart + 1;
        int halfEdge = edge / 2;

        int color = list[rowStart + halfEdge][colStart];
        for (int i = rowStart + halfEdge; i <= rowEnd; i++) {
            for (int j = colStart; j < colStart + halfEdge; j++) {
                if (list[i][j] != color) {
                    cut(table, rowStart + halfEdge, rowEnd, colStart, colStart + halfEdge - 1);
                    return;
                }
                    
            }
        }
        //System.out.println("row " + rowStart + "~" + rowEnd);
        //System.out.println("col " + colStart + "~" + colEnd);
        //System.out.println("ThreeAreaFinish");
        if (color == 1) {
            //System.out.println("res = blue");
            blue++;
        } else {
            //System.out.println("res = white");
            white++;
        }
        //System.out.println();
    }

    public static void checkFourArea(int[][] table, int rowStart, int rowEnd, int colStart, int colEnd) {

        int edge = rowEnd - rowStart + 1;
        int halfEdge = edge / 2;

        int color = list[rowStart + halfEdge][colStart + halfEdge];
        //System.out.println("color = " + color);
        for (int i = rowStart + halfEdge; i <= rowEnd; i++) {
            for (int j = colStart + halfEdge; j <= colEnd; j++) {
                //System.out.println("list[" + i + "][" + j + "] = " + list[i][j]);
                if (list[i][j] != color) {
                    cut(table, rowStart + halfEdge, rowEnd, colStart + halfEdge, colEnd);
                    return;
                }
            }
        }
        //System.out.println("row " + rowStart + "~" + rowEnd);
        //System.out.println("col " + colStart + "~" + colEnd);
        //System.out.println("FourAreaFinish");
        if (color == 1) {
            //System.out.println("res = blue");
            blue++;
        } else {
            //System.out.println("res = white");
            white++;
        }
        //System.out.println();
    }
}
