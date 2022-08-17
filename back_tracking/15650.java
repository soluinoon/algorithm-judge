import java.io.*;
import java.util.*;

/*
 * 15649 N과 M 1
 * 
 */

public class Main {

    static int n, m;
    static int res[];
    static int visit[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(st.nextToken());

        res = new int[m];
        visit = new int[n + 1];

        findComb(0, 0);
    }

    static void findComb(int number, int count) {
        //System.out.println("findcomb : (" + number + "," + count + ")");
        if (count == m) {
            sb = new StringBuilder();
            for (int i = 1; i <= m; i++) {
                sb.append(res[i - 1]);
                if (i != m)
                    sb.append(" ");
            }
            System.out.println(sb);
            return;
        }
        res[count] = number;
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0 && i > number) {
                visit[i] = 1;
                res[count] = i;
                findComb(i, count + 1);
                visit[i] = 0;
            }
        }
    }
}