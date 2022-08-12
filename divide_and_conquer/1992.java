import java.io.*;
import java.util.*;

/*
 * 15649 쿼드트리
 * 
 */

public class Main {

    static int n;
    static int list[][];
    static int ans[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        list = new int[n][n];

        for (int i = 0; i < n; i++) {
        String temp = br.readLine();
            for (int j = 0; j < n; j++) {
                list[i][j] = temp.charAt(j) - '0';
            }
        }

        // excute
        checkAndDivide(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    public static void checkAndDivide(int startRow, int endRow, int startCol, int endCol) {
        
        int colorTemp = list[startRow][startCol];

        if (checkEnd(startRow, endRow, startCol, endCol) != -1) {
            sb.append(colorTemp);
            return;
        }
        sb.append('(');
        int aredDivideNumber = (endRow - startRow - 1) / 2;
        // 2area
        checkAndDivide(startRow, startRow + aredDivideNumber, startCol, startCol + aredDivideNumber);
        // 1area
        checkAndDivide(startRow, startRow + aredDivideNumber, endCol - aredDivideNumber, endCol);
        // 3area
        checkAndDivide(endRow - aredDivideNumber, endRow, startCol, startCol + aredDivideNumber);
        // 4ared
        checkAndDivide(endRow - aredDivideNumber, endRow, endCol - aredDivideNumber, endCol);

        sb.append(')');
    }

    public static int checkEnd(int startRow, int endRow, int startCol, int endCol) {
        int colorTemp = list[startRow][startCol];

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (list[i][j] != colorTemp) {
                    return -1;
                }
            }
        }

        return colorTemp;
    }
}