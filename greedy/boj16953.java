import java.util.*;
import java.io.*;

class Main {
    /**
     * https://www.acmicpc.net/problem/16953
     * 16953 A->B
     */
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        findMinimumCost(number, target, 1);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }

    private static void findMinimumCost(long number, int target, int cost) {
        if (number > target) {
            return;
        }
        if (number == target) {
            if (cost < min) {
                min = cost;
                return;
            }
        }
        findMinimumCost(number * 2, target, cost + 1);
        findMinimumCost(addOneToRight(number), target, cost + 1);
    }

    private static long addOneToRight(long number) {
        number *= 10;
        number += 1;
        return number;
    }
}
