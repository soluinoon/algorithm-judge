import java.io.*;
import java.util.*;

/*  
 *  백준 2493 탑
 *  https://www.acmicpc.net/problem/2493
 */ 

public class Main {
    
    static int n;
    static int temp;
    static Stack<int[]> top;

    static int[] ans;
    static int indexTemp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        top = new Stack<>();
        ans = new int[n + 1];

        // input & init
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            while (!top.isEmpty()) {
                if (top.peek()[0] > temp) {
                    sb.append(top.peek()[1] + " ");
                    break;
                }
                top.pop();
            }
            if (top.isEmpty())
                sb.append("0 ");
            top.push(new int[] {temp, i});
        }
        System.out.println(sb);

        }
}


