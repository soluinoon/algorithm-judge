import java.io.*;
import java.util.*;

class Main {
    /**
     * 1764
     * 2022-12-17
     */
    static HashMap<String, Integer> map = new HashMap<>();
    static ArrayList<String> answer = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1);
        }

        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                count++;
                answer.add(key);
            }
        }
        System.out.println(count);
        Collections.sort(answer);
        for (String str : answer) {
            System.out.println(str);
        }
    }
}