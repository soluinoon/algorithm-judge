import java.util.*;
import java.io.*;

/*
 * 23289 온풍기 안녕!
 * 
 */

public class Main {


    static int row, col, k,numberOfWall, chocolate;
    static int list[][];
    static int listTemp[][];
    // 0 up 1 right 2 down 3 left
    static int mrow[] = {-1, 0, 1, 0};
    static int mcol[] = {0, 1, 0, -1};

    static ArrayList<int[]> checkList;
    static ArrayList<int[]> heater;
    static ArrayList<Integer> wall[][];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        wall = new ArrayList[row + 1][col + 1];
        list = new int[row + 1][col + 1];
        listTemp = new int[row + 1][col + 1];
        checkList = new ArrayList<>();
        heater = new ArrayList<>();

        // input
        for (int i = 1; i < row + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < col + 1; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 5) 
                    checkList.add(new int[] {i,j});
                else if (temp == 1)
                    heater.add(new int[] {i, j, 1});
                else if (temp == 2)
                    heater.add(new int[] {i, j, 3});
                else if (temp == 3)
                    heater.add(new int[] {i, j, 0});
                else if (temp == 4)
                    heater.add(new int[] {i, j, 2});
                wall[i][j] = new ArrayList<>();
            }
        }
        
        numberOfWall = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfWall; i++) {
            st = new StringTokenizer(br.readLine());
            int rowTemp = Integer.parseInt(st.nextToken());
            int colTemp = Integer.parseInt(st.nextToken());
            int among = Integer.parseInt(st.nextToken());
            
            if (among == 1) {
                wall[rowTemp][colTemp].add(1);
                wall[rowTemp][colTemp + 1].add(3);
            } else if (among == 0) {
                wall[rowTemp][colTemp].add(0);
                wall[rowTemp - 1][colTemp].add(2);
            }
        }

        // execute

        while (true) {
        //System.out.println("@@@@@@chocolate" + chocolate);
        tempSetZero();

        // 1. heater on
        for (int i = 0; i < heater.size(); i++) {
            //System.out.println("i = " + i);
            int temp[] = heater.get(i);
            int ori = temp[2];
            int y = temp[0] + mrow[ori];
            int x = temp[1] + mcol[ori];

            if (y <= row && y >= 1 && x <= col && x >= 1) {
                if (!wall[temp[0]][temp[1]].contains(ori))
                    spread(5, y, x, ori);
            }
            //printingTemp();
            renewList();
            tempSetZero();
        }
        //System.out.println("after heating");
        //printing();

        // 2. temperature control
        tempSetZero();
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                //if (list[i][j] != 0) {
                    // down
                    if (!wall[i][j].contains(2)) {
                        int downRow = i + mrow[2];
                        int downCol = j + mcol[2];
                        if (downRow <= row && downRow >= 1 && downCol <= col && downCol >= 1) {
                            int amount = (list[i][j] - list[downRow][downCol]) / 4;
                            listTemp[i][j] -= amount;
                            listTemp[downRow][downCol] += amount;
                        }
                    }
                    // right
                    if (!wall[i][j].contains(1)) {
                        int rightRow = i + mrow[1];
                        int rightCol = j + mcol[1];
                        if (rightRow <= row && rightRow >= 1 && rightCol <= col && rightCol >= 1) {
                            int amount = (list[i][j] - list[rightRow][rightCol]) / 4;
                            listTemp[i][j] -= amount;
                            listTemp[rightRow][rightCol] += amount;
                        }
                    }
                //}
            }
        }
        renewList();
        tempSetZero();
        //System.out.println("after temperature control");
        //printing();

        // 3. edge minus
        for (int i = 1; i < row + 1; i++) {
            if (list[i][1] > 0)
                list[i][1]--;
            if (list[i][col] > 0)
                list[i][col]--;
        }

        for (int i = 2; i < col; i++) {
            if (list[1][i] > 0)
                list[1][i]--;
            if (list[row][i] > 0)
                list[row][i]--;
        }
        //System.out.println("after edge minus");
        //printing();

        // 4. eat chocolate
        chocolate++;
        // 5. check check
        int res = checkResult();
        if (res == 1 || chocolate == 101) {
            System.out.println(chocolate);
            break;
        }
    }
    }
    public static void tempSetZero() {
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                listTemp[i][j] = 0;
            }
        }
    }
    public static int checkResult() {
        
        for (int i = 0; i < checkList.size(); i++) {
            int temp[] = checkList.get(i);
            if (list[temp[0]][temp[1]] < k)
                return 0;
        }
        return 1;
    }

    public static void printing() {
        System.out.println("list");
        for (int i = 0; i < list.length; i++) {
            System.out.println(Arrays.toString(list[i]));
        }
        System.out.println();
    }

    public static void printingTemp() {
        System.out.println("listTemp");
        for (int i = 0; i < listTemp.length; i++) {
            System.out.println(Arrays.toString(listTemp[i]));
        }
        System.out.println();
    }

    public static void renewList() {
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                list[i][j] += listTemp[i][j];
            }
        }
    }

    public static void spread(int heat, int y, int x, int ori) {
        if (heat == 0 || y > row || y < 1 || x > col || x < 1)
            return;
        // System.out.println("row=" + y + " col=" + x + " heat=" + heat);
        listTemp[y][x] = heat;
        // straight
        if (!wall[y][x].contains(ori)) {
            spread(heat - 1, y + mrow[ori], x + mcol[ori], ori);
        }
        int alterOri = ori + 2;
        if (alterOri >= 4)
            alterOri -= 4;
        
        // left cross
        int leftCrossOri = ori - 1;
        if (leftCrossOri == -1)
            leftCrossOri = 3;
        if (!wall[y][x].contains(leftCrossOri)) {
            int leftCrossY = y + mrow[ori] + mrow[leftCrossOri];
            int leftCrossX = x + mcol[ori] + mcol[leftCrossOri];
            if (leftCrossY <= row && leftCrossY >= 1 && leftCrossX <= col && leftCrossX >= 1) {
                // System.out.println("leftRoW=" + leftCrossY + " leftCol=" + leftCrossX);
                if (!wall[leftCrossY][leftCrossX].contains(alterOri))
                    spread(heat - 1, leftCrossY, leftCrossX, ori);
            }
        }
        
        // right cross
        int rightCrossOri = ori + 1;
        if (rightCrossOri == 4)
            rightCrossOri = 0;
        if (!wall[y][x].contains(rightCrossOri)) {
            int rightCrossY = y + mrow[ori] + mrow[rightCrossOri];
            int rightCrossX = x + mcol[ori] + mcol[rightCrossOri];
            if (rightCrossY <= row && rightCrossY >= 1 && rightCrossX <= col && rightCrossX >= 1) {
                if (!wall[rightCrossY][rightCrossX].contains(alterOri))
                    spread(heat - 1, rightCrossY, rightCrossX, ori);
            }
        }
    }
}