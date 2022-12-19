import java.io.*;
import java.util.*;

class Main {
    /**
     * 1620
     * 2022-12-17
     */
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // input
        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            map.put(temp, i);
            list.add(temp);
        }

        // logic
        for (int i = 1; i <= m; i++) {
            String temp = br.readLine();
            if (map.containsKey(temp)) {
                System.out.println(map.get(temp));
            } else {
                System.out.println(list.get(Integer.parseInt(temp) - 1));
            }
        }
    }
}