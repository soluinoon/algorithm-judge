import java.io.*;
import java.util.*;

class Main {
    /**
     * 1193
     * 분수찾기
     * 22-12-29
     */

    static int n;
    static int flag = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1 + "/" + 1);
            return;
        }

        int count = 1;
        int left;
        int right;
        for (int i = 2; i < 100000000; i++) {
            if (flag == -1) {
                left = i;
                right = 1;
            } else {
                left = 1;
                right = i;
            }
            count++;
            if (count == n) {
                System.out.println(left + "/" + right);
                return;
            }
            for (int j = 0; j < i - 1; j++) {
                if (flag == -1) {
                    count++;
                    left--;
                    right++;
                } else {
                    count++;
                    left++;
                    right--;
                }
                if (count == n) {
                    System.out.println(left + "/" + right);
                    return;
                }
            }
            flag *= -1;
        }
    }
}