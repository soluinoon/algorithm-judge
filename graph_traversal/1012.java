import java.io.*;
import java.util.*;

public class Main {

    static int list[][];
    static int visited[][];
    static int test_n;
    static ArrayList<Integer> ans;
    static int count;
    static int row, col, groc;
    static int my[] = {-1, 1, 0, 0};
    static int mx[] = {0, 0, -1, 1};
    static String temp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

    

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        test_n = Integer.parseInt(br.readLine());
        ans = new ArrayList<>();

        for (int I = 0 ; I < test_n; I++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            groc = Integer.parseInt(st.nextToken());

            list = new int[row][col];
            visited = new int [row][col];

            for (int i = 0; i < groc; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list[y][x] = 1;
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (visited[i][j] == 0 && list[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            ans.add(count);
        }
            for (int i = 0; i < ans.size(); i++) {
                System.out.println(ans.get(i));
            }

    }

    public static void bfs(int y, int x) {

        // int count = 0;
        Queue<int[]> q = new LinkedList<>();

        visited[y][x] = 1;
        q.offer(new int[] {y, x});
        while(!q.isEmpty()) {
            int[] nextnode = q.poll();
            int nextY = nextnode[0];
            int nextX = nextnode[1];
            // count++;
            for (int i = 0; i < 4; i++) {
                nextY = my[i] + nextnode[0];
                nextX = mx[i] + nextnode[1];
                if (nextX < 0 || nextX >= col || nextY < 0 || nextY >= row )
                    continue;
                if (visited[nextY][nextX] != 1 && list[nextY][nextX] != 0) {
                    // list[nextX][nextY] = list[nextnode[0]][nextnode[1]] + 1;
                    q.offer(new int[] {nextY, nextX});
                    visited[nextY][nextX] = 1;
                }
            }
        }
        //return count;
    }

}