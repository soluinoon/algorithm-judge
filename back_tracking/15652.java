import java.io.*;
import java.util.*;

/*
 * 15649 N과 M 1
 * 
 */

public class Main {

    static int n, m;
    static int res[];
    //static int visit[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(st.nextToken());

        res = new int[m];
        sb = new StringBuilder();

        //visit = new int[n + 1];

        findComb(0, 0);
        System.out.print(sb);
    }

    static void findComb(int number, int count) {
        //System.out.println("findcomb : (" + number + "," + count + ")");
        if (count == m) {
            for (int i = 1; i <= m; i++) {
                sb.append(res[i - 1]);
                if (i != m)
                    sb.append(" ");
                else
                    sb.append("\n");
            }
            return;
        }
        //res[count] = number;
        for (int i = 1; i <= n; i++) {
            //if (visit[i] == 0) {
                //visit[i] = 1;
                if (number <= i) {
                    res[count] = i;
                    findComb(i, count + 1);
                }
                //visit[i] = 0;
            //}
        }
    }
}