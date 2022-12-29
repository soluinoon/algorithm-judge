import java.io.*;
import java.util.*;

class Main {
    /**
     * 10250
     * ACM 호텔
     * 22-12-29
     */

    static int height, width, n, tcase;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < tcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            System.out.println(getRoomNumber(height, width, n));
        }
    }

    public static int getRoomNumber(int height, int width, int n) {
        int front = n % height;
        if (front == 0) {
            front = height;
        }
        int back = 1 + ((n - 1) / height);

        return front * 100 + back;
    }
}