// 2606 바이러스

import java.io.*;
import java.util.*;


public class Main {

    static ArrayList<Integer> list[];
    static int visit[];
    static int n;
    static int count;
    static int pair;
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        visit = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < pair; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            
            list[temp1].add(temp2);
            list[temp2].add(temp1);
        }
        
        bfs(1);

        System.out.println(count);

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visit[start] = 1;

        while(!q.isEmpty()) {
            int crt = q.poll();
            
            for (int i = 0; i < list[crt].size(); i++) {
                int next = list[crt].get(i);
                if (visit[next] != 1) {
                    count++;
                    q.offer(next);
                    visit[next] = 1;
                }
            }
        }
    }
}