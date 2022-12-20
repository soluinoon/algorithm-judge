import java.io.*;
import java.util.*;

class Main {
    /**
     * 1167
     * 2022-12-20
     */
    static ArrayList<ArrayList<int []>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int memo;
//    static ArrayList<int []> footage = new ArrayList<>();
//    static ArrayList<int []> answerFootage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int count = 0;

        visited = new boolean[size + 1];

        initGraph(size);
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());

            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) {
                    break;
                }
                int value = Integer.parseInt(st.nextToken());

                // 앞에서 갱신했으면 패스
                if (node < cur) {
                    continue;
                }

                graph.get(cur).add(new int[] {node, value});
                graph.get(node).add(new int[] {cur, value});
            }
        }
//        System.out.println("graph");
//        for (int i = 1; i < graph.size(); i++) {
//            System.out.println("when i = " + i);
//            for (int j = 0; j < graph.get(i).size(); j++) {
//                System.out.println(graph.get(i).get(j)[0] + " " + "value =" + graph.get(i).get(j)[1]);
//            }
//        }

        // logic
        visited[1] = true;
        dfs(1, 0);
        visited[1] = false;
        int far = memo;
        visited[far] = true;
        dfs(memo, 0);
        visited[far] = false;

        System.out.println(max);
        //System.out.println(memo);

//        for (int i = 0; i < answerFootage.size(); i++) {
//            System.out.println(answerFootage.get(i)[0] + " " + answerFootage.get(i)[1]);
//        }
    }

    public static void initGraph(int size) {
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void dfs(int cur, int dist) {
        if (isEnd(cur)) {
            if (dist > max) {
                memo = cur;
                max = dist;
            }
            return;
        }
        ArrayList<int []> near = graph.get(cur);
        for (int i = 0; i < near.size(); i++) {
            int next = near.get(i)[0];
            int value = near.get(i)[1];

            if (!visited[next]) {
                visited[next] = true;
                dfs(next, dist + value);
                visited[next] = false;
            }
        }
    }

    public static boolean isEnd(int cur) {
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int node = graph.get(cur).get(i)[0];
            if (!visited[node]) {
                return false;
            }
        }
        return true;
    }
}