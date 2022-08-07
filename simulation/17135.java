import java.io.*;
import java.util.*;


public class Main {

    static int list[][];
    static int listTemp[][];
    static int catchCount;

    static int row, col, distanceLimit;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        distanceLimit = Integer.parseInt(st.nextToken());
        
        list = new int[row][col];
        listTemp = new int[row][col];

        // input
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // execute
        
        for (int archer1 = 0; archer1 < col; archer1++) {
            for (int archer2 = archer1 + 1; archer2 < col; archer2++) {
                for (int archer3 = archer2 + 1; archer3 < col; archer3++) {
                    // brute force
                    listCopy();
                    int catchTemp = 0;
                    /* 
                    int[] enemy1 = {-1, -1};
                    int[] enemy2 = {-1, -1};
                    int[] enemy3 = {-1, -1};
                    int distance1 = Integer.MAX_VALUE;
                    int distance2 = Integer.MAX_VALUE;
                    int distance3 = Integer.MAX_VALUE;
                    */
                    while (isEnemyLeft()) {

                        ArrayList<int[]> enemy1List = new ArrayList<>();
                        ArrayList<int[]> enemy2List = new ArrayList<>();
                        ArrayList<int[]> enemy3List = new ArrayList<>();

                        int distance1 = Integer.MAX_VALUE;
                        int distance2 = Integer.MAX_VALUE;
                        int distance3 = Integer.MAX_VALUE;

                        for (int i = row - 1; i >= 0; i--) {
                            for (int j = 0; j < col; j++) {
                                if (listTemp[i][j] == 1) {
                                    int temp1 = getDistance(archer1, i, j);
                                    int temp2 = getDistance(archer2, i, j);
                                    int temp3 = getDistance(archer3, i, j);

                                    if (temp1 <= distanceLimit && temp1 <= distance1) {
                                        distance1 = temp1;
                                        enemy1List.add(new int[] {i, j, temp1});
                                    }
                                    if (temp2 <= distanceLimit && temp2 <= distance2) {
                                        distance2 = temp2;
                                        enemy2List.add(new int[] {i, j, temp2});

                                    }
                                    if (temp3 <= distanceLimit && temp3 <= distance3) {
                                        distance3 = temp3;
                                        enemy3List.add(new int[] {i, j, temp3});

                                    }
                                }
                            }
                        }
                        int[] enemy1 = getEnemy(enemy1List);
                        int[] enemy2 = getEnemy(enemy2List);
                        int[] enemy3 = getEnemy(enemy3List);
                        /* 
                        System.out.println("enemy1 = " + enemy1[0] + " " + enemy1[1]);
                        System.out.println("enemy2 = " + enemy2[0] + " " + enemy2[1]);
                        System.out.println("enemy3 = " + enemy3[0] + " " + enemy3[1]);
                        */
                        if (enemy1[0] != row) {
                            if (listTemp[enemy1[0]][enemy1[1]] != 0) {
                                listTemp[enemy1[0]][enemy1[1]] = 0;
                                catchTemp++;
                            }
                        }
                        if (enemy2[0] != row) {
                            if (listTemp[enemy2[0]][enemy2[1]] != 0) {
                                listTemp[enemy2[0]][enemy2[1]] = 0;
                                catchTemp++;
                            }
                        }
                        if (enemy3[0] != row) {
                            if (listTemp[enemy3[0]][enemy3[1]] != 0) {
                                listTemp[enemy3[0]][enemy3[1]] = 0;
                                catchTemp++;
                            }
                        }
                        moveEnemy();
                        //printing();
                    }
                    //System.out.println("catchcount = " + catchTemp);
                    if (catchTemp > catchCount)
                        catchCount = catchTemp;
                }
            }
        }
        System.out.println(catchCount);
    }

    public static int getDistance(int archerCol, int y, int x) {
        // row gap + col gap
        int distanceRow = row - y;
        int distanceCol = x - archerCol;

        if (distanceCol < 0)
            distanceCol *= -1;
        //System.out.println("dis = " + (distanceCol + distanceRow));
        return (distanceRow + distanceCol);
    }
    
    public static void moveEnemy() {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (listTemp[i][j] == 1) {
                    int nextRow = i + 1;
                    if (nextRow < row) {
                        listTemp[nextRow][j] = 1;
                    } 
                    listTemp[i][j] = 0;
                }
            }
        }
    }

    public static boolean isEnemyLeft() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (listTemp[i][j] == 1)
                    return true;
            }
        }
        return false;
    }

    public static void listCopy() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                listTemp[i][j] = list[i][j];
            }
        }
    }

    public static void printing() {
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(listTemp[i]));
        }
    }

    public static int[] getEnemy(ArrayList<int[]> enemyList) {
        if (enemyList.isEmpty())
            return new int[] {row, col};
        int shortestDistance = Integer.MAX_VALUE;
        int shortestTemp = -1;
        for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i)[2] < shortestDistance) {
                shortestDistance = enemyList.get(i)[2];
                shortestTemp = i;
            }
        }

        int lowest = enemyList.get(shortestTemp)[1];
        int index = shortestTemp;
        for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i)[2] <= shortestDistance) {
                int tempCol = enemyList.get(i)[1];
                if (tempCol < lowest) {
                    index = i;
                } 
            }
        }
        return enemyList.get(index);
    }
}
