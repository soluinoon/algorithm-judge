// 14499 주사위굴리기
import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int row, col, x, y;
    static int up, down;

    /*
     * 1 동쪽 -> x + 1
     * 2 서쪽 -> x - 1
     * 3 북쪽 -> y - 1
     * 4 남쪽 -> y + 1
     */

    static int mx[] = {0, 1, -1, 0, 0};
    static int my[] = {0, 0, 0, -1, 1};
    static int diceStat[] = {0, 0, 0, 0, 0, 0, 0};
    static int list[][];
    static int order[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        list = new int[row][col];
        order = new int[n];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            diceMove(order[i]);
        }
    }

    /*
     * 1 동쪽 -> x + 1
     * 2 서쪽 -> x - 1
     * 3 북쪽 -> y - 1
     * 4 남쪽 -> y + 1
     */

     /*
      *   2
        4 1 3
          5
          6
      */
    public static void diceMove(int ori) {
        
        int nextX = x + mx[ori];
        int nextY = y + my[ori];

        if (nextX < 0 || nextX >= col || nextY < 0 || nextY >= row)
            return;
        diceSpin(ori);
        if (list[nextY][nextX] == 0) {
            list[nextY][nextX] = diceStat[6];  
        } else {
            diceStat[6] = list[nextY][nextX];
            list[nextY][nextX] = 0;
        }
        x = nextX;
        y = nextY;
        System.out.println(diceStat[1]);
    }
/*
     * 1 동쪽 -> x + 1
     * 2 서쪽 -> x - 1
     * 3 북쪽 -> y - 1
     * 4 남쪽 -> y + 1
     */
    /*
      *   2
        4 1 3
          5
          6
      */
    public static void diceSpin(int ori) {
        int newDice[] = new int[7];

        if (ori == 1) {
            newDice[1] = diceStat[4];
            newDice[2] = diceStat[2]; 
            newDice[3] = diceStat[1]; 
            newDice[4] = diceStat[6]; 
            newDice[5] = diceStat[5]; 
            newDice[6] = diceStat[3]; 
        } else if (ori == 2) { 
            newDice[1] = diceStat[3];
            newDice[2] = diceStat[2]; 
            newDice[3] = diceStat[6]; 
            newDice[4] = diceStat[1]; 
            newDice[5] = diceStat[5]; 
            newDice[6] = diceStat[4]; 
        } else if (ori == 3) {
            newDice[1] = diceStat[5];
            newDice[2] = diceStat[1]; 
            newDice[3] = diceStat[3]; 
            newDice[4] = diceStat[4]; 
            newDice[5] = diceStat[6]; 
            newDice[6] = diceStat[2]; 
        } else if (ori == 4) {
            newDice[1] = diceStat[2];
            newDice[2] = diceStat[6]; 
            newDice[3] = diceStat[3]; 
            newDice[4] = diceStat[4]; 
            newDice[5] = diceStat[1]; 
            newDice[6] = diceStat[5]; 
        }
        diceStat = newDice;
    }
}
