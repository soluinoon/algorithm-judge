import java.io.*;
import java.util.*;

public class Main {
    /**
     * 24479
     * 알고리즘 수업 - 깊이 우선 탐색 1
     * 22-12-31
     */

    static int seq = 1;
    static boolean[] visited;
    static ArrayList<Integer> answer = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int node;
        int edge;
        int start;
        int temp1, temp2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[node + 1];
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
            answer.add(0);
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            temp1 = Integer.parseInt(st.nextToken());
            temp2 = Integer.parseInt(st.nextToken());
            graph.get(temp1).add(temp2);
            graph.get(temp2).add(temp1);
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(start);

        for (int i = 1; i <= node; i++) {
            System.out.println(answer.get(i));
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        answer.set(node, seq);
        seq++;

        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}