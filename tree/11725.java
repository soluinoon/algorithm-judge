import java.io.*;
import java.util.*;

class Main {
    /**
     * 11725
     * 2022-12-20
     */
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int count = 0;

        visited = new boolean[size + 1];
        parents = new int[size + 1];
        initGraph(size);
        for (int i = 0; i < size - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            graph.get(number1).add(number2);
            graph.get(number2).add(number1);
        }

        // logic
        bfs();
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void initGraph(int size) {
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void bfs() {
        Deque<Integer> q = new LinkedList<>();

        q.add(1);
        while (!q.isEmpty()) {
            Integer cur = q.poll();
            visited[cur] = true;
            // System.out.println("cur = " + cur);
            ArrayList<Integer> near = graph.get(cur);
            // System.out.println("near = " + near);
            for (Integer node : near) {
                if (visited[node] == true) {
                    parents[cur] = node;
                    // System.out.println("parent of " + cur + " is " + node);
                } else {
                    q.add(node);
                }
            }
        }
    }
}