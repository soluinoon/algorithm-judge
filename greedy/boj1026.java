import java.io.*;
import java.util.*;

public class Main {
    /**
     * https://www.acmicpc.net/problem/1026
     * 1026 보물
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];


        // input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // sort
        Arrays.sort(a);
        Arrays.sort(b);

        // logic
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (a[i] * b[n - i - 1]);
        }
        System.out.println(sum);
    }
}