import java.util.*;
import java.io.*;

/*
 * 17143
 * 낚시왕
 * 
 */

public class Main {

    static int[][] list;
    static int[][] listTemp;
    static ArrayList<Integer>[][] jaws;
    static ArrayList<Integer>[][] jawsTemp;
    static int[] mrow = {0, -1, 1, 0, 0};
    static int[] mcol = {0, 0, 0, 1, -1};
    static int row, col, sharkEA, res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        sharkEA = Integer.parseInt(st.nextToken());

        list = new int[row + 1][col + 1];
        listTemp = new int[row + 1][col + 1];
        jaws = new ArrayList[row + 1][col + 1];
        jawsTemp = new ArrayList[row + 1][col + 1];


        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                jaws[i][j] = new ArrayList<>();
                jawsTemp[i][j] = new ArrayList<>();
            }
        }
        // 리스트에는 크기 저장하고 죠스에는 0:속력, 1:방향 저장
        for (int i = 0; i < sharkEA; i++) {
            st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                // 0:속력, 1:방향 저장
                jaws[r][c].add(Integer.parseInt(st.nextToken()));
                jaws[r][c].add(Integer.parseInt(st.nextToken()));
                list[r][c] = Integer.parseInt(st.nextToken());
        }

        // excute
        for (int time = 1; time < col + 1; time++) {
            int fisherman = time;

            for (int j = 1; j < row + 1; j++) {
                int shark = list[j][fisherman];
                if (shark > 0) {
                    res += shark;
                    list[j][fisherman] = 0;
                    jaws[j][fisherman].clear();
                    break;
                }
            }
            
            // shark move
            listTemp = new int[row + 1][col + 1];
            tempClear(jawsTemp);
            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < col + 1; j++) {
                    if (!jaws[i][j].isEmpty()) {
                        sharkMove(i, j);
                    }
                }
            }
            list = listTemp;
            tempClearAndCopy();
        }

        System.out.println(res);
    }

    static void sharkMove(int i, int j) {
        int ori = jaws[i][j].get(1);
        int vel = jaws[i][j].get(0);

        int nextRow = i;
        int nextCol = j;


        if (i == row) {
            if (ori == 2) {
                ori = 1;
            }
        } else if (nextRow == 1) {
            if (ori == 1) {
                ori = 2;
            }
        }

        if (j == col) {
            if (ori == 3)
                ori = 4;
        } else if (nextCol == 1) {
            if (ori == 4)
                ori = 3;
        }

        for (int k = 0; k < vel; k++) {
            nextRow = nextRow + mrow[ori];
            nextCol = nextCol + mcol[ori];
            if (nextRow == row) {
                if (ori == 2) {
                    ori = 1;
                }
            } else if (nextRow == 1) {
                if (ori == 1) {
                    ori = 2;
                }
            }

            if (nextCol == col) {
                if (ori == 3)
                    ori = 4;
            } else if (nextCol == 1) {
                if (ori == 4)
                    ori = 3;
            }
        }

        if (listTemp[nextRow][nextCol] < list[i][j]) {
            listTemp[nextRow][nextCol] = list[i][j];
            jawsTemp[nextRow][nextCol].clear();
            jawsTemp[nextRow][nextCol].add(vel);
            jawsTemp[nextRow][nextCol].add(ori);
        }
    }

    static void tempClear(ArrayList<Integer> list[][]) {
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                list[i][j].clear();
                
            }
        }
    }

    static void tempClearAndCopy() {
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                jaws[i][j].clear();
                jaws[i][j].addAll(jawsTemp[i][j]);
            }
        }
    }
}