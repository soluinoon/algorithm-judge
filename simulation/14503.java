import java.io.*;
import java.util.*;

public class Main {

    static int list[][];
    static int count;
    static int row, col;
    static int start_x, start_y, start_ori;
    // 0 북 1 동 2 남 3 서
    static int my[] = {-1, 0, 1, 0};
    static int mx[] = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        list = new int[row][col];

        st = new StringTokenizer(br.readLine());
        start_y = Integer.parseInt(st.nextToken());
        start_x = Integer.parseInt(st.nextToken());
        start_ori = Integer.parseInt(st.nextToken());

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < col; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 빈칸 0, 벽 1 임의로 청소한 곳을 -1로 지정

        clean(start_x, start_y, start_ori);
        System.out.println(count);
    }

    static void clean(int x, int y, int ori) {
        
        int i;

        int left_ori;
        int back_ori = ori + 2;
        if (back_ori >= 4)
            back_ori -= 4;

        // 1. 현재 위치 청소
        if (list[y][x] == 0) {
            count++;
            list[y][x] = -1;
        }
        
        //왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
        for (i = 0; i < 4; i++) {
            left_ori = turnLeft(ori - i);
            if (list[y + my[left_ori]][x + mx[left_ori]] == 0) {
                clean(x + mx[left_ori] ,y + my[left_ori], left_ori);
                return;
            }
        }
        //네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
        for (i = 0; i < 4; i++) {
            if (list[y + my[i]][x + mx[i]] == 0)
                break;
        }
        if (i == 4 && list[y + my[back_ori]][x + mx[back_ori]] == 1)
            return;
        //네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        clean(x + mx[back_ori] ,y + my[back_ori], ori);

    }

    static int turnLeft(int ori) {
        int left_ori = ori - 1;
        
        if (left_ori < 0)
            left_ori += 4;
        return left_ori;
    }
}