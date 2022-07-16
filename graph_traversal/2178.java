// 2178 미로탐색 bfs

import java.io.*;
import java.util.*;

public class App {

    static int list[][];
    static int visited[][];
    static int row;
    static int col;
    static int count;
    static int mx[] = {-1, 1, 0, 0};
    static int my[] = {0, 0, -1, 1};
    static String temp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

    

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        // tart = Integer.parseInt(st.nextToken());

        list = new int[row + 1][col + 1];
        visited = new int [row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            temp = br.readLine();
            for (int j = 1; j <= col; j++) {
                list[i][j] = (int)(temp.charAt(j - 1) - '0');

            }
        }

        bfs(1, 1);
       
        System.out.println(list[row][col]);
}

    public static void bfs(int x, int y) {

        // Queue<List[]> q = new LinkedList<>();
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = 1;
        q.offer(new int[] {x, y});
        while(!q.isEmpty()) {
            int[] nextnode = q.poll();
            int nextX = nextnode[0];
            int nextY = nextnode[1];

            for (int i = 0; i < 4; i++) {
                nextX = mx[i] + nextnode[0];
                nextY = my[i] + nextnode[1];
                if (nextX < 1 || nextX > row || nextY < 1 || nextY > col )
                    continue;
                if (visited[nextX][nextY] != 1 && list[nextX][nextY] != 0) {
                    list[nextX][nextY] = list[nextnode[0]][nextnode[1]] + 1;
                    q.offer(new int[] {nextX, nextY});
                    visited[nextX][nextY] = 1;
                }
            }
        }
    }

}
