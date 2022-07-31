import java.util.*;
import java.io.*;

/*
 * 16235 나무재테크
 * 시작 시간 10:43
 */

public class Main {

    static int[][] list;
    static int[][] table;
    static ArrayList<Integer>[][] tree;
    static int[] mrow = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] mcol = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int n, m, time;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        list = new int[n + 1][n + 1];
        table = new int[n + 1][n + 1];
        tree = new ArrayList[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                list[i][j] = 5;
                tree[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            tree[row][col].add(age);
        }
        printing();
        for (int i = 0; i < time; i++) {
            spring();
        }
        printing();
    }

    static void spring() {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (!tree[i][j].isEmpty()) {
                    Collections.sort(tree[i][j]);
                    for (int k = 0; k < tree[i][j].size(); k++) {
                        int age = tree[i][j].get(k);
                        int energy = list[i][j];
                        if (energy < age) {
                            summer(i, j, k, energy);
                            break;
                        } else {
                            energy -= age;
                            tree[i][j].set(k, age--);
                        }
                    }
                }
            }
        }
    }

    static void summer(int i, int j, int k, int energy) {

        for (int index = k; index < tree[i][j].size(); index++) {
            energy += tree[i][j].get(k) / 2;
            tree[i][j].remove(k);
        }
        list[i][j] = energy;
    }

    static void printing() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(list[i]));
        }
        System.out.println();

        
    }
}
