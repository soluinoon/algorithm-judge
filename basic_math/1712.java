import java.io.*;
import java.util.*;

class Main {
    /**
     * 1712
     * 손익분기점
     * 22-12-27
     */
    static long base, makingPrice, sellPrice;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        base = Integer.parseInt(st.nextToken());
        makingPrice = Integer.parseInt(st.nextToken());
        sellPrice = Integer.parseInt(st.nextToken());

        if (makingPrice >= sellPrice) {
            System.out.println(-1);
            return;
        }

        System.out.println((base / (sellPrice - makingPrice)) + 1);
    }
}