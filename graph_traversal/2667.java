import java.io.*;
import java.util.*;

public class Main {

    static int list[][];
    static int visited[][];
    static int n;
    static ArrayList<Integer> ans;
    static int count;
    static int mx[] = {-1, 1, 0, 0};
    static int my[] = {0, 0, -1, 1};
    static String temp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

    

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        list = new int[n + 1][n + 1];
        visited = new int [n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            temp = br.readLine();

            for (int j = 1; j <= n; j++) {
                list[i][j] = (int)(temp.charAt(j - 1) - '0');
            }
        }

        ans = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (visited[i][j] == 0 && list[i][j] == 1) {
                    count++;
                    int res = bfs(i, j);
                    ans.add(res);
                }
            }
        }
        Collections.sort(ans);
        System.out.println(count);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        
}

    public static int bfs(int x, int y) {

        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        visited[x][y] = 1;
        q.offer(new int[] {x, y});
        while(!q.isEmpty()) {
            int[] nextnode = q.poll();
            int nextX = nextnode[0];
            int nextY = nextnode[1];
            count++;
            for (int i = 0; i < 4; i++) {
                nextX = mx[i] + nextnode[0];
                nextY = my[i] + nextnode[1];
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > n )
                    continue;
                if (visited[nextX][nextY] != 1 && list[nextX][nextY] != 0) {
                    // list[nextX][nextY] = list[nextnode[0]][nextnode[1]] + 1;
                    q.offer(new int[] {nextX, nextY});
                    visited[nextX][nextY] = 1;
                }
            }
        }
        return count;
    }

}