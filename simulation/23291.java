import java.util.*;
import java.io.*;

/*
 * 23291 어항정리
 * 
 */

public class Main {

    static ArrayList<Integer> jar[];
    static ArrayList<Integer> jarTemp[][];
    static int[] reset;
    
    static int count, n, k;
    static int[] next;
    static int alphabet[]; //-65;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    
        jar = new ArrayList[n];
        jarTemp = new ArrayList[n][n];

        // input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            jar[i] = new ArrayList<>();
            jar[i].add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                jarTemp[i][j] = new ArrayList<>();
            }
        }
        //printing();
        while (true) {
        // excute
        // 1. fill minimum jar
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = jar[i].get(0);
            if (min > temp)
                min = temp;
        }
        for (int i = 0; i < n; i++) {
            if (min == jar[i].get(0)) {
                jar[i].set(0, min + 1);
            }
        }

        // 2. jar[0] to jar[1]
        jar[1].add(jar[0].get(0));
        jar[0].remove(0);
        
        // 3. spin
        for (int i = 1; i < jar.length; i++) {

            int up = 0;
            for (int j = i; j < jar.length; j++) {
                if (jar[j].size() < 2)
                    break;
                up++;
            }

            if (jar[i].size() > n - (i + up)) {
                break;
            }
            // check size > 1

            // spin and add
            spinAndAdd(i, up);
            i = i + up - 1;
        }
        //printing();

        // 4 get gap
        // 0-up 1-right 2-down 3-left
        tempClear();
        for (int i = 0; i < jar.length; i++) {
            for (int j = 0; j < jar[i].size(); j++) {
                checkUp(i, j);
                checkRight(i, j);
            }
        }
        getGap();
        //printing();

        // 5 re-set
        reSet();
        //printing();

        // 6 180spin two time
        for (int i = 0; i < n / 2; i++) {
            jar[n - 1 - i].add(jar[i].get(0));
            jar[i].clear();
        }
        //printing();
        int patch = (n - (n / 2)) / 2 - 1;
        for (int i = 1; i >= 0; i--) {
            int index = n - n / 4;
            for (int j = n / 2 + patch; j >= n / 2; j--) {
                jar[index].add(jar[j].get(i));
                jar[j].remove(i);
                index++;
            }
        }
        //printing();
        tempClear();
        for (int i = 0; i < jar.length; i++) {
            for (int j = 0; j < jar[i].size(); j++) {
                checkUp(i, j);
                checkRight(i, j);
            }
        }
        getGap();
        //printing();
        reSet();
        //printing();
        count++;
        int res = checkResult();
        if (res == 1) {
            System.out.println(count);
            break;
        }
    }
}

    public static void spinAndAdd(int start, int up) {
        // from (start + up) add
        for (int i = start + up - 1; i >= start; i--) {
            for (int j = 0; j < jar[i].size(); j++) {
                jar[start + up + j].add(jar[i].get(j));
            }
            jar[i].clear();
        }
    }

    public static void printing() {
        for (int i = 0; i < jar.length; i++) {
            System.out.print("jar[" + i + "] ");
            for (int j = 0; j < jar[i].size(); j++) {
                System.out.print(jar[i].get(j) + " ");
            }
            System.out.println();
        }
    System.out.println();

    }

    public static void tempClear() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                jarTemp[i][j].clear();
            }
        }
    }

    public static void checkUp(int i, int j) {

        if (j + 1 < jar[i].size()) {
            int temp = (jar[i].get(j) - jar[i].get(j + 1)) / 5;
            if (temp == 0)
                return;
            // temp = negative -> up > down
            // temp = positive -> up < down
            jarTemp[i][j + 1].add(temp);
            jarTemp[i][j].add(-1 * temp);
        }
    }

    public static void checkRight(int i, int j) {

        if (i + 1 < n && jar[i + 1].size() >= j + 1) {
            int temp = (jar[i].get(j) - jar[i + 1].get(j)) / 5;
            if (temp == 0)
                return;
            // temp = negative -> right > left
            // temp = positive -> left < right
            jarTemp[i + 1][j].add(temp);
            jarTemp[i][j].add(-1 * temp);
        }
    }

    public static void getGap() {

        for (int i = 0; i < jar.length; i++) {
            for (int j = 0; j < jar[i].size(); j++) {
                int temp = jar[i].get(j);
                for (int k = 0; k < jarTemp[i][j].size(); k++) {
                    temp += jarTemp[i][j].get(k);
                }
                jar[i].set(j, temp);
            }
        }
    }
    
    public static void reSet() {
        reset = new int[n];

        int index = 0;
        for (int i = 0; i < jar.length; i++) {
            for (int j = 0; j < jar[i].size(); j++) {
                reset[index] = jar[i].get(j);
                index++;
            }
            jar[i].clear();
        }

        for (int i = 0; i < jar.length; i++) {
            jar[i].add(reset[i]);
        }
    }

    public static int checkResult() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = jar[i].get(0);
            if (temp < min)
                min = temp;
            if (temp > max)
                max = temp;
        }
        if (max - min <= k)
            return 1;
        else 
            return 0;
    }
}