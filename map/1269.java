import java.io.*;
import java.util.*;

class Main {
    /**
     * 1269
     * 2022-12-19
     */
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            // 1은 A-B
            // 2는 B-A
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 3) - 1);
//            System.out.println("temp =" + temp + " map =" + map.get(temp));
        }

        for (Integer value : map.values()) {
            if (value == 1 || value == 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}