// 3190 snake

import java.io.*;
import java.util.*;

public class Main {

    static int list[][];
    static int time;
    static int nextCurl[];
    static int tail[] = {1, 1};
    static int head[] = {1, 1};
    static int n, k, l;
    static int row, col;
    static int change_time; 
    // 0 북 1 동 2 남 3 서
    static int my[] = {-1, 0, 1, 0};
    static int mx[] = {0, 1, 0, -1};
    static ArrayList<int[]> change;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        change = new ArrayList<>();
        list = new int[n + 1][n + 1];
        // apple
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            list[row][col] = -1;
        }
        // change time
        l = Integer.parseInt(br.readLine());
        // System.out.println("l = " + l);
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            change_time = Integer.parseInt(st.nextToken());
            String ori = st.nextToken();
            if (ori.equals("D")) {
                //System.out.println("d");
                change.add(new int[] {change_time, 1});
            }
            else if (ori.equals("L")) {
                //System.out.println("l");
                change.add(new int[] {change_time, -1});

            }
        }

        list[1][1] = 1;
        if (!change.isEmpty())
            nextCurl = findNextCurl(change);
        travel(1, 1, 1);
        System.out.println(time);
    }
    /*
     * 0 = can move
     * -1 = apple
     * positive = snake(sequence)
     */
    static void travel(int x, int y, int ori) {
        
        int i;
        int next_x = x + mx[ori];
        int next_y = y + my[ori];
        time++;

         
        //System.out.println("travel nextx:" + (next_x) + " nexty:" + (next_y) + " ori:" + ori + " list = " + list[next_y][next_x]);
        //System.out.println("head:(" + head[0] + "," + head[1] + ")");
        //System.out.println("tail:(" + tail[0] + "," + tail[1] + ")");
        //System.out.println("nextCurl:(" + nextCurl[0] + "," + nextCurl[1] + ")");
        

        // 1. move head
        if ((next_x > n || next_x <= 0|| next_y > n || next_y <= 0)) {
            return;
        } else if (list[next_y][next_x] > 0) {
            return;
        } else {
            head[0] = next_x;
            head[1] = next_y;

          // 2. move tail (no apple)
            if (list[next_y][next_x] != -1) {
                list[next_y][next_x] = time;
                tail = moveTail();
            } else
                list[next_y][next_x] = time;
        }
        if (time == nextCurl[0]) {
            if (nextCurl[1] == 1) {
                ori = turnRight(ori);
            }
            else if (nextCurl[1] == -1) {
                ori = turnLeft(ori);
            }
            if (!change.isEmpty())
                nextCurl = findNextCurl(change);
        }
        
        travel(next_x, next_y, ori);
    }

    static int turnLeft(int ori) {
        int left_ori = ori - 1;
        
        if (left_ori < 0)
            left_ori += 4;
        //System.out.println("return left = " + left_ori);
        return left_ori;
    }

    static int turnRight(int ori) {
        int right_ori = ori + 1;
        
        if (right_ori > 3)
            right_ori -= 4;
        //System.out.println("return right = " + right_ori);
        return right_ori;
    }

    // where is next tail have to go
    static int[] moveTail() {

        int nextTail[];
        int lowestTime = Integer.MAX_VALUE;
        int temp_x;
        int temp_y;

        // check up ~ left
        nextTail = new int[2];
        for (int i = 0; i < 4; i++) {
            temp_x = tail[0] + mx[i];
            temp_y = tail[1] + my[i];
            if (temp_x > n || temp_x <= 0 || temp_y > n || temp_y <= 0)
                continue;
            if (list[temp_y][temp_x] < lowestTime && list[temp_y][temp_x] > 0) {
                lowestTime = list[temp_y][temp_x];
                nextTail[0] = temp_x;
                nextTail[1] = temp_y;
            }
        }
        list[tail[1]][tail[0]] = 0;
        return (nextTail);
    }

    static int[] findNextCurl(ArrayList<int[]> arr) {
        int time = Integer.MAX_VALUE;
        int ansIndex = Integer.MAX_VALUE;
        int[] ans; 

        for (int i = 0; i < arr.size(); i++) {
            if (time > arr.get(i)[0]) {
                time = arr.get(i)[0];
                ansIndex = i;
            }
        }
        ans = arr.get(ansIndex);
        arr.remove(ansIndex);
        return ans;
    }   
}