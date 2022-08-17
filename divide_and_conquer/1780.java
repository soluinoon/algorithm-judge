import java.io.*;
import java.util.*;

/*
 * 1780 종이의 갯수
 * 
 */

public class Main {

    static int n;
    static int list[][];
    static int ans[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        list = new int[n][n];
        ans = new int[3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // excute
        checkAndDivide(0, n - 1, 0, n - 1);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);

    }

    public static void checkAndDivide(int startRow, int endRow, int startCol, int endCol) {
        
        int colorTemp = list[startRow][startCol];
        //System.out.println("ct = "  + colorTemp);
        if (checkEnd(startRow, endRow, startCol, endCol) != -2) {
            ans[colorTemp + 1]++;
            return;
        }

        int aredDivideNumber = (endRow - startRow - 2) / 3;
        //System.out.println("areaDivideNumber = " + aredDivideNumber);
        // (1,1) ~ (1,3) area
        checkAndDivide(startRow, startRow + aredDivideNumber, startCol, startCol + aredDivideNumber);
        checkAndDivide(startRow, startRow + aredDivideNumber, startCol + aredDivideNumber + 1, endCol - aredDivideNumber - 1);
        checkAndDivide(startRow, startRow + aredDivideNumber, endCol - aredDivideNumber, endCol);

        // 2,1 ~ 2,3 area
        checkAndDivide(startRow + aredDivideNumber + 1, endRow - aredDivideNumber - 1, startCol, startCol + aredDivideNumber);
        checkAndDivide(startRow + aredDivideNumber + 1, endRow - aredDivideNumber - 1, startCol + aredDivideNumber + 1, endCol - aredDivideNumber - 1);
        checkAndDivide(startRow + aredDivideNumber + 1, endRow - aredDivideNumber - 1, endCol - aredDivideNumber, endCol);

        // 3,1 ~ 3,3 area
        checkAndDivide(endRow - aredDivideNumber, endRow, startCol, startCol + aredDivideNumber);
        checkAndDivide(endRow - aredDivideNumber, endRow, startCol + aredDivideNumber + 1, endCol - aredDivideNumber - 1);
        checkAndDivide(endRow - aredDivideNumber, endRow, endCol - aredDivideNumber, endCol);

    }

    public static int checkEnd(int startRow, int endRow, int startCol, int endCol) {

        int colorTemp = list[startRow][startCol];

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (list[i][j] != colorTemp) {
                    return -2;
                }
            }
        }

        return colorTemp;
    }
}