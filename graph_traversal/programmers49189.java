import java.util.*;

class Solution {
    static int[] visited;
    
    public int solution(int n, int[][] edge) {
        visited = new int[n + 1];
        Arrays.sort(edge, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        int max = bfs(edge);
        int answer = 0;
        for (int i = 0 ; i < visited.length; i++) {
            if (visited[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private int bfs(int[][] edge) {
        int max = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        while (!q.isEmpty()) {
            int number = q.poll();
            ArrayList<Integer> adjList = getAdjList(number, edge);
            for (int i = 0; i < adjList.size(); i++) {
                int element = adjList.get(i);
                visited[element] = visited[number] + 1;
                if (max < visited[element]) {
                    max = visited[element];
                    // System.out.println(String.format("max = %d", max));
                }
                q.add(element);
            }
        }
        return max;
    }
    
    private ArrayList<Integer> getAdjList(int number, int[][] edge) {
        ArrayList<Integer> adjList = new ArrayList<>();
        
        for (int i = 0; i < edge.length; i++) {
            if (edge[i][0] == number && visited[edge[i][1]] == 0) {
                adjList.add(edge[i][1]);
            } else if (edge[i][1] == number && visited[edge[i][0]] == 0) {
                adjList.add(edge[i][0]);
            }
        }
        return adjList;
    }
}
