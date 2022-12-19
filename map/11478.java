import java.io.*;
import java.util.*;

class Main {
    /**
     * 11478
     * 2022-12-17
     */
    static HashMap<String, Integer> map = new HashMap<>();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine());
        int len = sb.length();

        for (int i = 1; i <= len; i++) {
            addMap(i, len, sb);
        }
//        for (String key : map.keySet()) {
//        if (map.get(key) == 1) {
//            count++;
//            }
//        }
//        System.out.println(count);
        System.out.println(map.size());
    }

    public static void addMap(int size, int len, StringBuilder sb) {
        int start = 0;
        int end = size - 1;

        while (end < len) {
            String sub = sb.substring(start, end + 1);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
//            System.out.println("sub = " + sub + " map = " + map.get(sub));
            start++;
            end++;
        }
    }
}