import java.util.*;
import java.io.*;

/*
 * 10875 뱀
 * 1:36 시작
 */

public class Main {

    static long[][] list;
    // 초기엔 동쪽
    static int ori = 1;
    static int Alltime, time, n;
    // 북동남서
    static int mrow[] = {-1, 0, 1, 0};
    static int mcol[] = {0, 1, 0, -1};

    static Queue<Integer> spinList;

    static int spinNumber;
    static int nextSpinTime;
    static int nextSpinOri;
    static int[] head;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        // input
        int size = n * 2 + 1;
        System.out.println(size);
        list = new long[size][size];
        list[n][n] = 1;
        head = new int[] {n, n};
        spinList = new LinkedList<>();

        spinNumber = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < spinNumber; i++) {
            st = new StringTokenizer(br.readLine());
            spinList.add(Integer.parseInt(st.nextToken()));
            char temp = st.nextToken().charAt(0);
            //System.out.println(temp);
            if (temp == 'L')
                spinList.add(-1);
            else if (temp == 'R')
                spinList.add(1);
        }

        //System.out.println(spinListTime.toString());
        //System.out.println(spinListOri.toString());

        // excute
        getNextSpin();
        while (true) {

            Alltime++;
            time++;

            // grow
            int nextRow = head[0] + mrow[ori];
            int nextCol = head[1] + mcol[ori];
            //System.out.println("next = [" + nextRow + "," + nextCol + "]");
            if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size || list[nextRow][nextCol] != 0) {
                //System.out.println("crush");
                break;
            }

            head[0] = nextRow;
            head[1] = nextCol;
            list[head[0]][head[1]] = Alltime;

            // spin
            if (time == nextSpinTime) {
                //System.out.println("spin");
                ori = ori + nextSpinOri;
                if (ori == -1)
                    ori = 3;
                else if (ori == 4)
                    ori = 0;
                time = 0;
                getNextSpin();
                //System.out.println("next time = " + nextSpinTime);
                //System.out.println("next ori = " + nextSpinOri);
            }
        }
        System.out.println(Alltime);
    }
    
    static void getNextSpin() {

        if (!spinList.isEmpty()) {
            nextSpinTime = spinList.poll();
            nextSpinOri = spinList.poll();
        } else {
            nextSpinTime = -1;
        }

    }
}