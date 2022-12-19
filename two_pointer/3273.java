import java.io.*;
import java.util.*;

class Main {
    /**
     * 3273
     * 2022-12-19
     */
    static int[] arr;
    static int p1, p2;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int count = 0;

        // input
        arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());

        // logic
        Arrays.sort(arr);
        p1 = 0;
        p2 = 1;
        while (p1 < arr.length - 1) {
            if (arr[p1] + arr[p2] == x) {
                count++;
                p1++;
                p2 = p1 + 1;
            } else if (arr[p1] + arr[p2] < x) {
                p2++;
                if (p2 > arr.length - 1) {
                    p1++;
                    p2 = p1 + 1;
                }
            } else { // p1 + p2 > x
                p1++;
                p2 = p1 + 1;
            }
        }
        System.out.println(count);
    }
}