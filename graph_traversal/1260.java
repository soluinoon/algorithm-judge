import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> list[];
    static int visited[];
    static int node;
    static int edge;
    static int start;
    static int temp1, temp2;
    public static void main(String[] args) throws IOException {

    

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new ArrayList[node + 1];
        visited = new int[node + 1];

    

        for (int i = 0; i <= node; i++) {
            list[i] = new ArrayList<>();
        }

     

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            temp1 = Integer.parseInt(st.nextToken());
            temp2 = Integer.parseInt(st.nextToken());
            list[temp1].add(temp2);
            list[temp2].add(temp1);
        }
        for (int i = 0; i < list.length; i++) {
            Collections.sort(list[i]);
        }

       
    

       dfs(start);

       Arrays.fill(visited, 0);
       System.out.print("\n");

       bfs(start);
    }

    public static void dfs(int x) {

        visited[x] = 1;
        System.out.print(x + " ");
        for (int i = 0; i < list[x].size(); i++) {
            int nextnode = list[x].get(i);
            if (visited[nextnode] != 1) {
                dfs(nextnode);
            }
        }
    }

    public static void bfs(int x) {

        // Queue<List[]> q = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        System.out.print(x + " ");
        visited[x] = 1;
        q.offer(x);
        while(!q.isEmpty()) {
            int nextnode = q.poll();
            for (int i = 0; i < list[nextnode].size(); i++) {
                int temp = list[nextnode].get(i);
                if (visited[temp] != 1) {
                    q.offer(temp);
                    visited[temp] = 1;
                    System.out.print(temp + " ");

                }
            }
        }
    }
}