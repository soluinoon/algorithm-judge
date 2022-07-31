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
        //System.out.println("row" + row);
        //System.out.println("col" + col);


        // excute
        for (int time = 1; time < col + 1; time++) {
            //System.out.println("#####time : " + time + "#######");
            int fisherman = time;
            // catch
            for (int j = 1; j < row + 1; j++) {
                int shark = list[j][fisherman];
                //System.out.println("shark " + shark);
                if (shark > 0) {
                    //System.out.println("catch [" + time + "," + j + "]");
                    res += shark;
                    list[j][fisherman] = 0;
                    jaws[j][fisherman].clear();
                    break;
                }
            }
            
            // shark move
            listTemp = new int[row + 1][col + 1];
            //System.out.println("now");
            tempClear(jawsTemp);
            for (int i = 1; i < row + 1; i++) {
                for (int j = 1; j < col + 1; j++) {
                    // 동시에 움직여야 함!!
                    // 리스트를 하나 더 팔수도 있지만, 어레이 리스트와 리스트를 이용
                    if (!jaws[i][j].isEmpty()) {
                        sharkMove(i, j);
                    }
                }
            }

            list = listTemp;
            tempClearAndCopy();
            //printing();
        }

        System.out.println(res);
    }

    static void sharkMove(int i, int j) {
        //System.out.println("in :" + i + " " + j);
        int ori = jaws[i][j].get(1);
        int vel = jaws[i][j].get(0);

        int nextRow = i;
        int nextCol = j;


        if (i == row) {
            if (ori == 2) {
                //System.out.println("c");
                ori = 1;
                //System.out.println("ori =" + ori);
            }
        } else if (nextRow == 1) {
            if (ori == 1) {
                //System.out.println("cc");
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
            //System.out.println("NEXT [" + nextRow + "," + nextCol + "] ori=" + ori);
            if (nextRow == row) {
                if (ori == 2) {
                    //System.out.println("c");
                    ori = 1;
                    //System.out.println("ori =" + ori);
                }
            } else if (nextRow == 1) {
                if (ori == 1) {
                    //System.out.println("cc");
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
            //System.out.println("nori=" + ori);
        }

        if (listTemp[nextRow][nextCol] < list[i][j]) {
            //System.out.println("catch");
            listTemp[nextRow][nextCol] = list[i][j];
            //System.out.println("listTemp =" + listTemp[nextRow][nextCol]);
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
/* 
    static void printing() {
        for (int i = 1; i < row + 1; i++) {
            System.out.println(Arrays.toString(list[i]));
        }
        System.out.println();

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (!jaws[i][j].isEmpty()) {
                    System.out.print("jaws[" + i + "," + j + "]= ");
                    for (int k = 0; k < jaws[i][j].size(); k++) {
                        System.out.print(jaws[i][j].get(k) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
     */
}