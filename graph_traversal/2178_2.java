// dfs로 풀어서 실패
import java.io.*;
import java.util.*;

public class Main {

    static int list[][];
    static int visited[][];
    static int row;
    static int col;
    static int start;
    static int mx[] = {-1, 1, 0, 0};
    static int my[] = {0, 0, -1, 1};
    static String temp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

    

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        list = new int[row + 1][col + 1];
        visited = new int [row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            temp = br.readLine();
            for (int j = 1; j <= col; j++) {
                list[i][j] = (int)(temp.charAt(j - 1) - '0');

            }
        }

        dfs(1, 1, 0);
       
        System.out.println(min);
}

    public static void dfs(int x, int y, int count) {

        count++;
        if (x == row && y == col) {
            if (count < min);
                min = count;
            return;
        }
        if (count > min)
            return;
        visited[x][y] = 1;
        // up
        if (x > 1 && visited[x + mx[0]][y + my[0]] != 1 && list[x + mx[0]][y + my[0]] != 0) {
            dfs(x + mx[0], y + my[0], count);
            visited[x][y] = 0;
        }
        // down
        if (x < row && visited[x + mx[1]][y + my[1]] != 1 && list[x + mx[1]][y + my[1]] != 0) {
            dfs(x + mx[1], y + my[1], count);
            visited[x][y] = 0;
        }
        // left
        if (y > 1 && visited[x + mx[2]][y + my[2]] != 1 && list[x + mx[2]][y + my[2]] != 0) {
            dfs(x + mx[2], y + my[2], count);
            visited[x][y] = 0;
        }
        // right
        if (y < col && visited[x + mx[3]][y + my[3]] != 1 && list[x + mx[3]][y + my[3]] != 0) {
            dfs(x + mx[3], y + my[3], count);
            visited[x][y] = 0;
        }
    }
}