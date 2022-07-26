
// 5430 AC

import java.io.*;
import java.util.*;

public class App {

    static int n;
    static int k;
    static int revFlag = -1;
    static StringBuilder sb[];
    static String oper[];
    static StringBuilder answer[];

    static Deque<Integer> q;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        sb = new StringBuilder[n];
        oper = new String[n];
        answer = new StringBuilder[n];

        for (int i = 0; i <n; i++) {
            sb[i] = new StringBuilder();
            answer[i] = new StringBuilder();
        }

        Loop1 :
        for (int i = 0; i < n; i++) {
            // input
            oper[i] = br.readLine();
            k = Integer.parseInt(br.readLine());
            sb[i].append(br.readLine());

            int commaIndex = 0;
            int startIndex = 0;

            q = new ArrayDeque<>();

            if (k != 0) {
                while(sb[i].indexOf(",", startIndex + 1) != -1) {
                    commaIndex = sb[i].indexOf(",", startIndex + 1);
                    q.offer(Integer.parseInt(sb[i].substring(startIndex + 1, commaIndex)));
                    startIndex = commaIndex;
                }
                q.offer(Integer.parseInt(sb[i].substring(startIndex + 1, sb[i].length() - 1)));
            }
            
            // excute oper
            for (int j = 0; j < oper[i].length(); j++) {
                if (oper[i].charAt(j) == 'R') {
                    revFlag *= -1;
                }
                if (oper[i].charAt(j) == 'D') {
                    if (!q.isEmpty()) {
                        if (revFlag == -1)
                            q.poll();
                        else if (revFlag == 1)
                            q.pollLast();
                    }
                    else {
                        answer[i].append("error");
                        revFlag = -1;
                        continue Loop1;
                    }
                }
            }

            // making result
            StringBuilder res = new StringBuilder();
            res.append("[");
            if (revFlag == -1) {
                while (!q.isEmpty()) {
                    res.append(q.poll());
                    res.append(",");
                }
            } else if (revFlag == 1) {
                while (!q.isEmpty()) {
                    res.append(q.pollLast());
                    res.append(",");
                }
            }
            res.append("]");
            if (res.lastIndexOf(",") != -1)
                res.delete(res.lastIndexOf(","), res.lastIndexOf(",") + 1);

            answer[i] = res;
            revFlag = -1;
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println(answer[i]);
        }
    }

}