import java.io.*;
import java.util.*;

// start 1:14
// END 1:49

class Solution {
    static int answer = -1;
    static boolean[][] visited;
    // 상 하 좌 우 
    static int[] mrow = {-1, 1, 0, 0};
    static int[] mcol = {0, 0, -1, 1};
    
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        
        bfs(0, 0, maps);
        
        return answer;
    }
    
//     public void dfs(int row, int col, int count, int[][] maps) {
//         // System.out.printf("row=%d, col=%d, count = %d\n", row, col, count);
//         if (visited[row][col]) {
//             return;
//         }
//         if (row == maps.length - 1 && col == maps[0].length - 1) {
//             if (answer == -1 || answer > count)
//                 answer = count;
//             return;
//         }
        
//         for (int i = 0; i < 4; i++) {
//             int nextRow = row + mrow[i];
//             int nextCol = col + mcol[i];
            
//             if (canMove(nextRow, nextCol, maps)) {
//                 visited[row][col] = true;
//                 dfs(nextRow, nextCol, count + 1, maps);
//                 visited[row][col] = false;
//             }
//         }
//     }
    
    public void bfs(int row, int col, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            visited[cur.row][cur.col] = true;
            // System.out.printf("row=%d, col=%d, count = %d\n", cur.row, cur.col, cur.count);

            if (cur.row == maps.length - 1 && cur.col == maps[0].length - 1) {
                answer = cur.count;
                // System.out.println("catch");
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextRow = cur.row + mrow[i];
                int nextCol = cur.col + mcol[i];
                
                if (canMove(nextRow, nextCol, maps)) {
                    // System.out.printf("add row=%d, col=%d, count = %d\n", cur.row, cur.col, cur.count);
                    visited[nextRow][nextCol] = true;
                    q.add(new Node(nextRow, nextCol, cur.count + 1));
                }
                
            }
        }
    }
    
    class Node {
        int row;
        int col;
        int count;
        
        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    
    public boolean canMove(int row, int col, int[][] maps) {
        return row >= 0 && row < visited.length && col >= 0 && col < visited[0].length
                    && !visited[row][col] && maps[row][col] != 0;
    }
}
