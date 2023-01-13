import java.io.*;
import java.util.*;

public class Main {
    /**
     * https://www.acmicpc.net/problem/1931
     * 1931 회의실 배정
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] times = new int[n][2];

        // input
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        // sort
        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        // logic
        int minEndTime = -1;
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            // 시작시간이 이전시간의 종료시간 보다 이후이고, 종료시간이 이전시간보다 이후라면
            if (times[i][0] >= minEndTime && times[i][1] >= minEndTime) {
                count++;
                minEndTime = times[i][1];
            }
        }
        System.out.println(count);
    }
}