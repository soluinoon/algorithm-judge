import java.io.*;
import java.util.*;

import javax.sound.sampled.SourceDataLine;

/*  
 *  백준 17144 미세먼지 안녕
 *  https://www.acmicpc.net/problem/17144
 */ 

public class Main {
    
    static int row, col, time;

    static int[][] list;
    static int[][] listTemp;

    static int my[] = {-1, 1, 0, 0};
    static int mx[] = {0, 0, -1, 1};

    static ArrayList<int[]> swing;
    static int highAP;
    static int lowAP;

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        list = new int[row][col];
        listTemp = new int[row][col];


        // input
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
                // 공기청정기 위치 저장, 0으로 초기화 되고, 공기청정기는 무조건 위 아래 벽으로 2칸 이상 떨어져 있으므로, 윗공기청정기가 0이 아니면 아래 청정기다.
                if (list[i][j] == -1) {
                    if (highAP == 0) {
                        highAP = i;
                    }
                    else {
                        lowAP = i;
                    }
                }
            }
        }

        // execute
        for (int i = 0; i < time; i++) {
            // System.out.println("highAP = " + highAP + " lowAP = " + lowAP);
            listTemp = new int[row][col];
            spread();
            calcSpread();
            //printing(list);
            // System.out.println();
            excuteAP();
            //printing(list);
        }
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += list[i][j];
            }
        }
        sum += 2;
        System.out.println(sum);
    }

    public static void spread() {
       for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (list[i][j] >= 5) {
                    int spreadAmount = list[i][j] / 5;
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + my[k];
                        int nextCol = j + mx[k];
                        if (nextRow >= row || nextRow < 0 || nextCol >= col || nextCol < 0 || list[nextRow][nextCol] == -1)
                            continue;
                        listTemp[nextRow][nextCol] += spreadAmount;
                        count++;
                    }
                    list[i][j] = list[i][j] - (spreadAmount * count);
                }
            }
        }
    }

    public static void calcSpread() {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                list[i][j] = list[i][j] + listTemp[i][j];
            }
        }
    }
    
    public static void excuteAP() {
        // high
        int temp = list[0][col - 1];
        for (int i = highAP - 1; i >= 0 ; i--) {
            list[i + 1][0] = list[i][0];
            list[highAP - 1 - i][col - 1] = list[highAP - i][col - 1];
        }
        //System.out.println("after side");
        //printing(list);
        for (int i = col - 2; i >= 0; i--) {
            list[highAP][i + 1] = list[highAP][i];
            list[0][(col - 2) - i] = list[0][(col - 1) - i];
        }
        //System.out.println("after updown");
        list[0][col - 2] = temp;
        list[highAP][1] = 0;
        list[highAP][0] = -1;
        //printing(list);
        //System.out.println();

        // low
        temp = list[row - 1][col - 1];

        for (int i = row - 2; i >= lowAP ; i--) {
            list[i + 1][col - 1] = list[i][col - 1]; // right
        }
        for (int i = lowAP; i < row - 1; i++) {
            list[i][0] = list[i + 1][0];
        }
        //System.out.println("after low side");
        //printing(list);

        for (int i = col - 2; i >= 0; i--) {
            list[lowAP][i + 1] = list[lowAP][i];
            list[row - 1][(col - 2) - i] = list[row - 1][(col - 1) - i];
        }
        //System.out.println("after updown");
        list[row - 1][col - 2] = temp;
        list[lowAP][1] = 0;
        list[lowAP][0] = -1;
        //printing(list);
        //System.out.println();
    }
    /* 
    public static void printing(int[][] list) {
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(list[i]));
        }
    }
    */
}