import java.io.*;
import java.util.*;

/*
 * 2003 수들의 합
 * 
 */

public class Main {

    static int n, m;
    static int list[];
    static int res;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // input
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[n];

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // excute;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = i; j < n; j++) {
                temp += list[j];
                if (temp == m) {
                    res++;
                    //System.out.println("i=" + i + " j="+j);
                }
                if (temp > m)
                    break;
            }
        }

        System.out.println(res);

    }

    public static int getSum(int low, int high) {
        int sum = 0;
        
        for (int i = low; i <= high; i++) {
            sum += list[i];
        }
        
        return sum;
    }
}