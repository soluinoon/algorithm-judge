import java.io.*;
import java.util.*;

class Main {
    /**
     * 2869
     * 달팽이는 올라가고 싶다.
     * 22-12-29
     */

    static int speed, down, height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        speed = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        if (speed >= height) {
            System.out.println(1);
            return;
        }

        int minHeight = height - speed;
        int minDay = minHeight / (speed - down);
        if (minHeight % (speed - down) != 0) {
            minDay++;
        }

        System.out.println(minDay + 1);
    }
}