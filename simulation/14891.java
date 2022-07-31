import java.io.*;
import java.util.*;

import javax.sound.sampled.SourceDataLine;

/*  
 *  백준 14891 톱니바퀴
 *  https://www.acmicpc.net/problem/14891
 */ 

public class Main {
    
    static int n, res;
    static int point[];
    static int[][] list;
    static ArrayList<int[]> swing;
    static String temp;

    public static void main(String[] args) throws IOException {

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        list = new int[4][8];
        for (int i = 0; i < 4; i++) {
            temp = br.readLine();
            for (int j = 0; j < 8; j++) {
                list[i][j] = temp.charAt(j) - '0';
            }
        }
        // System.out.println(Arrays.toString(list[0]));
        // System.out.println(Arrays.toString(list[1]));
        // System.out.println(Arrays.toString(list[2]));
        // System.out.println(Arrays.toString(list[3]));

        n = Integer.parseInt(br.readLine());
        swing = new ArrayList<>();
        point = new int[4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int wheel = Integer.parseInt(st.nextToken());
            int ori = Integer.parseInt(st.nextToken());
            swing.add(new int[] {wheel - 1, ori});
        }

        // 12clock -> 0 index
        // 3 -> 2 index
        // 9 -> 6 index
        
        // ori -1 -> anticlockwise
        // ori +1 -> clockwise

        /*
         * touch list
         * 1) list[0][2] and list[1][6];
         * 2) list[1][2] and list[2][6];
         * 3) list[2][2] and list[3][6];
         */

        // execute
        for (int i = 0; i < n; i++) {
            int wheel = swing.get(i)[0];
            int ori = swing.get(i)[1];

            int[] pointTemp = point;

            leftSwing(wheel, ori, pointTemp);
            rightSwing(wheel, ori, pointTemp);
            swing(wheel, ori, point);
        }

        if (list[0][point[0]] == 1)
            res += 1;
        if (list[1][point[1]] == 1)
            res += 2;
        if (list[2][point[2]] == 1)
            res += 4;
        if (list[3][point[3]] == 1)
            res += 8;
        System.out.println(res);
        }

        static void swing(int wheel, int ori, int[] point) {
            // clockwise
            if (ori == -1) {
                point[wheel]++;
                if (point[wheel] > 7)
                    point[wheel] -= 8;
            } else if (ori == 1) {
                point[wheel]--;
                if (point[wheel] < 0)
                    point[wheel] += 8;
            }
        }
        
        static void leftSwing(int wheel, int ori, int[] pointTemp) {
            
            if (wheel > 0) {
                int touchpoint = pointTemp[wheel] - 2;
                if (touchpoint < 0)
                    touchpoint += 8;
                int touchpointLeft = pointTemp[wheel - 1] + 2;
                if (touchpointLeft > 7)
                    touchpointLeft -= 8;
                if (list[wheel][touchpoint] != list[wheel - 1][touchpointLeft]) {
                    //System.out.println("leftswing");
                    leftSwing(wheel - 1, ori * -1, pointTemp);
                    swing(wheel - 1, (ori * -1), point);
                }
            }
        }

        static void rightSwing(int wheel, int ori, int[] pointTemp) {
            
            if (wheel < 3) {
                int touchpoint = pointTemp[wheel] + 2;

                if (touchpoint > 7)
                    touchpoint -= 8;
                int touchpointRight = pointTemp[wheel + 1] - 2;
                if (touchpointRight < 0)
                    touchpointRight += 8;
                if (list[wheel][touchpoint] != list[wheel + 1][touchpointRight]) {
                    rightSwing(wheel + 1, ori * -1, pointTemp);
                    swing(wheel + 1, (ori * -1), point);
                }
            }
        }
    }