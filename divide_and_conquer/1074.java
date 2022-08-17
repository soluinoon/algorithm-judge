import java.io.*;
import java.util.*;
import java.lang.Math;

/*
 * 1074 Z
 * ㅁ
 */

public class Main {

    static int n, r, c;
    static int seq;
    static double time = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, n);
        // System.out.println("size = " + size);

        squareCheck(size, 0, size - 1, 0, size - 1);
    }   

    static void divideAndConquer(int rowStart, int rowEnd, int colStart, int colEnd) {

        int revice = (rowEnd - rowStart - 1) / 2;
        // System.out.println("revice = " + revice);
        // int size = rowEnd - rowStart + 1;

        if (rowEnd - rowStart <= 0) {
            if (rowStart == r && colStart == c) {
                System.out.println(seq);
                //System.out.println("time = " + (System.currentTimeMillis() - time) / 1000);
                System.exit(0);
            }
            seq++;

            //System.out.println("[" + rowStart + "," + colStart + "] = " + visit[rowStart][colStart]);
            return;
        }

        divideAndConquer(rowStart, rowStart + revice, colStart, colStart + revice);
        divideAndConquer(rowStart, rowStart + revice, colEnd - revice, colEnd);
        divideAndConquer(rowEnd - revice, rowEnd, colStart, colStart + revice);
        divideAndConquer(rowEnd - revice, rowEnd, colEnd - revice, colEnd);

    }

    static void squareCheck(int size, int rowStart, int rowEnd, int colStart, int colEnd) {

        //System.out.println("size = " + size);
        int dividePoint = size / 2;
        //System.out.println("dividePoint = " + dividePoint);

        // 1
        if (r < rowStart + dividePoint && r >= rowStart && c < colStart + dividePoint && c >= colStart) {
            if (dividePoint <= 1)
                divideAndConquer(rowStart, rowStart + dividePoint - 1, colStart, colStart + dividePoint - 1);
            else
                squareCheck(dividePoint, rowStart, rowStart + dividePoint - 1, colStart, colStart + dividePoint - 1);
        }

        // 2
        if (r < rowStart + dividePoint && r >= rowStart && c >= colStart + dividePoint && c <= colEnd) {
            seq += size * size / 4;
            if (dividePoint <= 1)
                divideAndConquer(rowStart, rowStart + dividePoint - 1, colStart + dividePoint, colEnd);
            else
                squareCheck(dividePoint, rowStart, rowStart + dividePoint - 1, colStart + dividePoint, colEnd);
        }

        // 3
        if (r <= rowEnd && r >= rowStart + dividePoint && c < colStart + dividePoint && c >= colStart) {
            seq += size * size / 2;
            if (dividePoint <= 1)
                divideAndConquer(rowStart + dividePoint, rowEnd, colStart, colStart + dividePoint - 1);
            else
                squareCheck(dividePoint, rowStart + dividePoint, rowEnd, colStart, colStart + dividePoint - 1);
        }

        // 4
        if (r <= rowEnd && r >= rowStart + dividePoint && c >= colStart + dividePoint && c <= colEnd) {
            seq += size * size / 4 * 3;
            if (dividePoint <= 1)
                divideAndConquer(rowStart + dividePoint, rowEnd, colStart + dividePoint, colEnd);
            else
                squareCheck(dividePoint, rowStart + dividePoint, rowEnd, colStart + dividePoint, colEnd);
        }
    }

}