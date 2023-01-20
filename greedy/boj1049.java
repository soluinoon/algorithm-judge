import java.io.*;
import java.util.*;

public class Main {
    /**
     * 2023-01-15
     * https://www.acmicpc.net/problem/1049
     * 1049 기타줄
     * 시작 시간 11:47
     * 완료 시간 12:20
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] packMoney = new int[m];
        int[] eachMoney = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            packMoney[i] = Integer.parseInt(st.nextToken());
            eachMoney[i] = Integer.parseInt(st.nextToken());
        }

        // logic
        int money = 0;
        money += buyPackge(n, packMoney, eachMoney);
        money += getMinMoneyBuyingN(n % 6, packMoney, eachMoney);
        System.out.println(money);
    }

    public static int buyPackge(int n, int[] packMoney, int[] eachMoney) {
        int minPackValue = getMinMoneyBuyingN(6, packMoney, eachMoney);

        return minPackValue * (n / 6);
    }

    public static int getMinMoneyBuyingN(int n, int[] packMoney, int[] eachMoney) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < packMoney.length; i++) {
            int money;
            if (packMoney[i] > eachMoney[i] * n) {
                money = eachMoney[i] * n;
            } else {
                money = packMoney[i];
            }
            if (money < min) {
                min = money;
            }
        }
        return min;
    }
}