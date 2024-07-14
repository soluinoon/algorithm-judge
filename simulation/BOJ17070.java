import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] wall;
    static int[][] board;
    static int n;
    static int answer;
    public enum Direction {
        RIGHT,
        DOWN,
        RIGHT_DOWN
    }

    public static List<Direction> getNextDirection(Direction direction) {
        if (direction == Direction.RIGHT) {
            return List.of(Direction.RIGHT, Direction.RIGHT_DOWN);
        }
        if (direction == Direction.RIGHT_DOWN) {
            return List.of(Direction.RIGHT, Direction.RIGHT_DOWN, Direction.DOWN);
        }
        if (direction == Direction.DOWN) {
            return List.of(Direction.DOWN, Direction.RIGHT_DOWN);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        wall = new int[n + 1][n + 1];
        board = new int[n + 1][n + 1];

        // input
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                wall[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // first, way of [1,1], [1,2] is '1'
        board[1][1] = 1;
        board[1][2] = 1;

        travel(1, 2, Direction.RIGHT);

        System.out.println(answer);
    }

    public static void travel(int row, int col, Direction direction) {
//        System.out.printf("travel [%d][%d] + %s\n", row, col, direction.toString());
        if (row == n && col == n) {
            answer++;
            return;
        }

        List<Direction> ableDirections = getNextDirection(direction);
//        System.out.printf("able = %s\n", ableDirections.toString());
        for (Direction nextDirection : ableDirections) {
            if (nextDirection == Direction.RIGHT && canMove(row, col + 1)) {
                travel(row, col + 1, Direction.RIGHT);
            }
            if (nextDirection == Direction.RIGHT_DOWN && canMove(row + 1, col + 1) && canMove(row + 1, col) && canMove(row, col + 1)) {
                travel(row + 1, col + 1, Direction.RIGHT_DOWN);
            }
            if (nextDirection == Direction.DOWN && canMove(row + 1, col)) {
                travel(row + 1, col, Direction.DOWN);
            }
        }
    }

    public static boolean canMove(int row, int col) {
        return !(row > n || col > n || row < 1 || col < 1 || wall[row][col] == 1);
    }
}
