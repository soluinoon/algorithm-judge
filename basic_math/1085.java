import java.io.*;
import java.util.*;

class Main {
    /**
     * 1085
     * 직사각형에서 탈출
     * 22-12-28
     */

    static int width, height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        int min1 = Math.min(getDistanceLeft(col, row), getDistanceRight(col, row));
        int min2 = Math.min(getDistanceUp(col, row), getDistanceDown(col, row));

        System.out.println(Math.min(min1, min2));
    }

    public static int getDistanceLeft(int x, int y) {
        return x;
    }

    public static int getDistanceRight(int x, int y) {
        return width - x;
    }

    public static int getDistanceUp(int x, int y) {
        return height - y;
    }

    public static int getDistanceDown(int x, int y) {
        return y;
    }
}