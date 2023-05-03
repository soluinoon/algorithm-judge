import java.io.*;
import java.util.*;



// tip: each public class is put in its own file
public class Main
{
    // 상 하 좌 우
    static int[] mrow = {-1, 1, 0, 0};
    static int[] mcol = {0, 0, -1, 1};
    static char[][] table;
    static boolean[][] visited;

    static int answer = -1;
    static Queue<Node> q = new LinkedList<>();


    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int startRow = 0;
        int startCol = 0;

        table = new char[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                table[i][j] = temp.charAt(j);
                if (temp.charAt(j) == 'J') {
                    startRow = i;
                    startCol = j;
                } else if (temp.charAt(j) == 'F') {
                    q.add(new Node(i, j, 'F', 0));
                }
            }
        }
        if (isEnd(startRow, startCol)) {
            System.out.println(1);
            return;
        }

        bfs(startRow, startCol);
        if (answer != -1) {
            System.out.println(answer);
        } else {
            System.out.println("IMPOSSIBLE");
        }
//        for (int i = 0; i < table.length; i++) {
//            for (int j = 0; j < table[0].length; j++) {
//                System.out.print(table[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    public static void bfs(int startRow, int startCol) {
        // {열, 행, 데이터}
        q.add(new Node(startRow, startCol, 'J', 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int row = cur.getRow();
            int col = cur.getCol();
            char data = cur.getData();
            int count = cur.getCount();

            // 사람
            if (data == 'J') {
//                System.out.println("row = " + row + ", col = " + col + " data =" + data);
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + mrow[i];
                    int nextCol = col + mcol[i];

                    if (canMove(nextRow, nextCol)) {
                        // 끝일때
                        if (isEnd(nextRow, nextCol)) {
                            answer = count + 2;
                            return;
                        } else {
                            table[nextRow][nextCol] = 'J';
                            visited[nextRow][nextCol] = true;
                            q.add(new Node(nextRow, nextCol, 'J', count + 1));
                        }
                    }
                }
            }
            // 불
            else if (data == 'F') {
//                System.out.println("row = " + row + ", col = " + col + " data =" + data);
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + mrow[i];
                    int nextCol = col + mcol[i];

                    if (canSpread(nextRow, nextCol)) {
                        table[nextRow][nextCol] = 'F';
                        q.add(new Node(nextRow, nextCol, 'F', count + 1));
                    }
                }
            }
        }
    }

    public static boolean isEnd(int row, int col) {
        return row == 0 || row == table.length - 1 || col == 0 || col == table[0].length - 1;
    }

    public static boolean canSpread(int row, int col) {
        return row >= 0 && row < table.length && col >= 0 && col < table.length
                && table[row][col] != 'F' && table[row][col] != '#';
    }

    public static boolean canMove(int row, int col) {
        return row >= 0 && row < table.length && col >= 0 && col < table[0].length
                && table[row][col] != 'F' && table[row][col] != '#' && visited[row][col] == false;
    }

    public static class Node {
        int row;
        int col;
        char data;
        int count;

        public Node(int row, int col, char data, int count) {
            this.row = row;
            this.col = col;
            this.data = data;
            this.count = count;
        }

        public int getRow() {
            return this.row;
        }
        public int getCol() {
            return this.col;
        }
        public char getData() {
            return this.data;
        }

        public int getCount() {
            return this.count;
        }
    }
}

// 상 하 좌 우
