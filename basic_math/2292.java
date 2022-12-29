import java.io.*;
import java.util.*;

class Main {
    /**
     * 2292
     * 벌집
     * 22-12-29
     */

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int count = 1;
        int sum = 1;
        while (true) {
            sum += (count * 6);
            if (n <= sum) {
                System.out.println(count + 1);
                break;
            }
            count++;
        }
    }
}