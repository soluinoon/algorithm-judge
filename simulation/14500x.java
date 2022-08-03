import java.util.*;
import java.io.*;

/*
 * 14500 테트로미노
 * 
 */

public class Main {

    static int[][] list;
    static int row, col;
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        list = new int[row][col];


        // input
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // excute
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                stickCheck(i, j);
                squareCheck(i, j);
                legCheck(i, j);
                chairCheck(i, j);
                tableCheck(i, j);
            }
        }
    }
        // 오른쪽으로, 아래쪽으로만 체크하면 나머지 안해도됨.
        public static void stickCheck(int i, int j) {
            int one = j;
            int two = j + 1;
            int three = j + 2;
            int four = j + 3;

            int temp;
            if (four < col) {
                temp = list[i][one] + list[i][two] + list[i][three] + list[i][four];
                if (res < temp)
                    res = temp;
            }

            one = i;
            two = i + 1;
            three = i + 2;
            four = i + 3;
            if (four < row) {
                temp = list[one][j] + list[two][j] + list[three][j] + list[four][j];
                if (res < temp)
                    res = temp;
            }
        }

        public static void squareCheck(int i, int j) {
            int square[][] = {{i,j}, {i,j+1}, {i + 1, j}, {i + 1, j + 1}};
            int temp;

            if (square[3][0] < row && square[3][1] < col) {
                temp = list[square[0][0]][square[0][1]] + list[square[1][0]][square[1][1]] + list[square[2][0]][square[2][1]] + list[square[3][0]][square[3][1]];
                if (res < temp)
                    res = temp;
            }
        }

        public static void legCheck(int i, int j) {
            int one;
            int two;
            int three;
            int four;

        }

        public static void chairCheck(int i, int j) {
            int one;
            int two;
            int three;
            int four;

        }

        public static void tableCheck(int i, int j) {


        }
    }
}