import java.util.*;
import java.io.*;

class Main {
    /**
     * https://www.acmicpc.net/problem/1753
     * 1753 
     */

    static boolean[] visited;
    static int[] dist;
    static ArrayList<ArrayList<int []>> adjList = new ArrayList<>();
    static Queue<int []> heap = new PriorityQueue<>((o1, o2) -> {
        return o1[1] - o2[1];
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        visited = new boolean[nodeNumber + 1];
        dist = new int[nodeNumber + 1];

        for (int i = 0; i <= nodeNumber; i++) {
            adjList.add(new ArrayList<>());
            dist[i] = -1;
        }

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList.get(node1).add(new int[] {node2, weight});
        }

//        for (int i = 1; i < adjList.size(); i++) {
////            System.out.print(String.format("%d) adjList = ", i));
//            for (int j = 0; j < adjList.get(i).size(); j++) {
////                System.out.print(String.format("[%d,%d] ", adjList.get(i).get(j)[0], adjList.get(i).get(j)[1]));
//           }
////            System.out.println();
//        }

        heap.add(new int[] {start, 0});
        dist[start] = 0;

        while (!heap.isEmpty()) {
            int[] node = heap.poll();
//            System.out.println(String.format("curNode = %d", node[0]));
            ArrayList<int[]> adj = adjList.get(node[0]);
            if (!visited[node[0]]) {
                visited[node[0]] = true;

                for (int i = 0; i < adj.size(); i++) {
                    if (dist[adj.get(i)[0]] == -1) {
                        dist[adj.get(i)[0]] = adj.get(i)[1] + dist[node[0]];
                    } else if (dist[adj.get(i)[0]] > adj.get(i)[1] + dist[node[0]]) {
                        dist[adj.get(i)[0]] = adj.get(i)[1] + dist[node[0]];
                    }
                    heap.add(new int[] {adj.get(i)[0], dist[adj.get(i)[0]]});
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == -1) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
